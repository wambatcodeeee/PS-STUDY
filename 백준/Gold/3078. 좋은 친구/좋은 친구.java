import java.io.*;
import java.util.*;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Queue<Integer>> queueList = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long pair = 0;

        for(int i = 0; i <= 20; i++){
            queueList.add(new LinkedList<>());
        }

        for(int i = 0; i < N; i++){
            String name = br.readLine();
            int length = name.length();
            Queue<Integer> queue = queueList.get(length);

            while(!queue.isEmpty() && queue.peek() < i - K){
                queue.poll();
            }

            pair += queue.size();
            queue.add(i);
        }

        System.out.println(pair);
    }
}
