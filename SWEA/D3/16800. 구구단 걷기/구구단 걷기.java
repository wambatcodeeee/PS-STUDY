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
            sb.append("#").append(t).append(" ");
            long N = Long.parseLong(br.readLine());
            long result = 0;

            for(int i = 1;i <= Math.sqrt(N);i++) if(N % i == 0) result = (N / i - 1) + (i - 1);
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}