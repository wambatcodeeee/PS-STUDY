import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 0;t < testCase;t++){
            int N = Integer.parseInt(br.readLine());
            long result = 1;
            PriorityQueue<Long> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0;i < N;i++) pq.add(Long.parseLong(st.nextToken()));
            while(pq.size() > 1){
                long first = pq.poll();
                long second = pq.poll();
                long target = (first * second) % 1000000007;
                result = (result * target) % 1000000007;
                pq.add(first * second);
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}