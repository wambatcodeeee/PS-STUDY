import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int num1 = Math.abs(o1);
            int num2 = Math.abs(o2);
            if(num1 == num2) return o1 - o2;

            return num1 - num2;
        });

        for(int i = 0; i < num; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            }else queue.add(x);
        }

        System.out.print(sb);
    }
}
