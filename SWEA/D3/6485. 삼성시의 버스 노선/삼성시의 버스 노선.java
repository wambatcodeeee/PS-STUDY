import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1;t <= testCase;t++){
            int N = Integer.parseInt(br.readLine());
            int[] stops = new int[5001];

            for(int i = 0;i < N;i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                for(int j = start;j <= end;j++) stops[j]++;
            }

            int P = Integer.parseInt(br.readLine());
            sb.append("#").append(t).append(" ");
            for(int i = 0;i < P;i++){
                int stop = Integer.parseInt(br.readLine());
                sb.append(stops[stop]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}