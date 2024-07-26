import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            int orderCase = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for(int j = 0; j < orderCase; j++){
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch(order){
                    case "I":
                        minQueue.add(num);
                        maxQueue.add(num);
                        hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
                        break;

                    case "D":
                        if(num == 1){
                            while(!maxQueue.isEmpty() && hashMap.get(maxQueue.peek()) == 0){
                                maxQueue.poll();
                            }
                            if(!maxQueue.isEmpty()){
                                int max = maxQueue.poll();
                                hashMap.put(max, hashMap.get(max) - 1);
                            }
                        }else if(num == -1){
                            while(!minQueue.isEmpty() && hashMap.get(minQueue.peek()) == 0){
                                minQueue.poll();
                            }
                            if(!minQueue.isEmpty()){
                                int min = minQueue.poll();
                                hashMap.put(min, hashMap.get(min) - 1);
                            }
                        }
                        break;
                }
            }

            while(!minQueue.isEmpty() && hashMap.get(minQueue.peek()) == 0){
                minQueue.poll();
            }
            while(!maxQueue.isEmpty() && hashMap.get(maxQueue.peek()) == 0){
                maxQueue.poll();
            }

            if(minQueue.isEmpty() || maxQueue.isEmpty()) bw.write("EMPTY" + "\n");
            else bw.write(maxQueue.peek() + " " + minQueue.peek() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
