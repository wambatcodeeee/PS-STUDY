import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for(int i = 2;i <= N;i++){
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        sb.append(dp[N]).append("\n");

        while(N > 0){
            sb.append(N).append(" ");
            if(N == 1) break;
            if(N % 2 == 0 && dp[N / 2] == dp[N] - 1) N /= 2;
            else if(N % 3 == 0 && dp[N / 3] == dp[N] - 1) N /= 3;
            else N -= 1;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}