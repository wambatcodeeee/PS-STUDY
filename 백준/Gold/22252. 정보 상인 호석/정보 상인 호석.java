import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, PriorityQueue<Integer>> hashMap = new HashMap<>();
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        long result = 0;

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());

            if(num1 == 1){
                String name = st.nextToken();
                int k = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> queue = hashMap.getOrDefault(name, new PriorityQueue<>(Collections.reverseOrder()));
                for(int j = 0; j < k; j++){
                    queue.offer(Integer.parseInt(st.nextToken()));
                }
                hashMap.put(name, queue);
            }else if (num1 == 2){
                String name = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                if(hashMap.containsKey(name)){
                    PriorityQueue<Integer> queue = hashMap.get(name);
                    for(int j = 0; j < b && !queue.isEmpty(); j++){
                        result += queue.poll();
                    }
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
