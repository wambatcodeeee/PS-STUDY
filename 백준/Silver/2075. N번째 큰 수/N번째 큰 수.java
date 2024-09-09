import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < num; j++){
                int nums = Integer.parseInt(st.nextToken());
                if(queue.size() < num) queue.add(nums);
                else if(nums > queue.peek()) {
                    queue.poll();
                    queue.add(nums);
                }
            }
        }

        System.out.println(queue.peek());
    }
}
