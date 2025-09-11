import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void solution(PriorityQueue<Integer> pq, int height, int chance) throws IOException {
        String result = "YES";
        int count = 0;

        while(!pq.isEmpty() && chance > 0){
            int current = pq.peek();
            if(current == 1 || current < height) break;
            int newHeight = pq.poll() / 2;
            pq.add(newHeight);
            count++;
            chance--;
        }

        if(pq.peek() >= height) result = "NO";

        bw.write(result + "\n");
        bw.write(result.equals("NO") ? String.valueOf(pq.peek()) : String.valueOf(count));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        st = new StringTokenizer(br.readLine());
        int giant = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int chance = Integer.parseInt(st.nextToken());

        for(int i = 0;i < giant;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        solution(pq, height, chance);

        bw.close();
        br.close();
    }
}