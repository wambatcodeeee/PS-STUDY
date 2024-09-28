import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int guest = Integer.parseInt(st.nextToken());
        int sushi = Integer.parseInt(st.nextToken());
        ArrayList<PriorityQueue<Integer>> orders = new ArrayList<>(200001);

        for(int i = 0; i < 200001; i++){
            orders.add(new PriorityQueue<>());
        }

        for(int i = 0; i < guest; i++){
            st = new StringTokenizer(br.readLine());
            int sushiNum = Integer.parseInt(st.nextToken());

            while(sushiNum-- > 0){
                orders.get(Integer.parseInt(st.nextToken())).offer(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] count = new int[guest];

        while(sushi-- > 0){
            int eatenSushi = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> queue = orders.get(eatenSushi);
            if(!queue.isEmpty()) count[queue.poll()]++;
        }

        for(int c : count){
            sb.append(c).append(" ");
        }

        System.out.println(sb);
    }
}
