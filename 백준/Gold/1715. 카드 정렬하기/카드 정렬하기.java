import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int num = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < num; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        while(queue.size() > 1){
            int first = queue.poll();
            int second = queue.poll();
            int total = first + second;
            result += total;
            queue.add(total);
        }

        System.out.println(result);
    }
}
