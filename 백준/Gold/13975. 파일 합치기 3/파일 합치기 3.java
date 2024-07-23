import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            PriorityQueue<Long> queue = new PriorityQueue<>();
            int num1 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long result = 0;

            for(int j = 0; j < num1; j++){
                queue.add(Long.parseLong(st.nextToken()));
            }

            while(queue.size() > 1){
                long first = queue.poll();
                long second = queue.poll();
                long cost = first + second;
                result += cost;
                queue.add(cost);
            }

            System.out.println(result);
        }
    }
}
