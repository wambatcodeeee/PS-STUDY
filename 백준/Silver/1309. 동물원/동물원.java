import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 3;
        if(N > 1){
            dp[2] = 7;
            for(int i = 3;i <= N;i++) dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
        }
        sb.append(dp[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}