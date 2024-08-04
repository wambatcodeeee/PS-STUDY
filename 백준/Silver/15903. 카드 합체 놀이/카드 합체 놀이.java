import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>();

        int num = Integer.parseInt(st.nextToken());
        int assemble = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            queue.offer(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < assemble; i++){
            long first = queue.poll();
            long second = queue.poll();
            long newValue = first + second;
            queue.offer(newValue);
            queue.offer(newValue);
        }

        long result = 0;

        while(!queue.isEmpty()){
            result += queue.poll();
        }

        System.out.println(result);
    }
}
