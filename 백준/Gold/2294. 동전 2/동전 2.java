import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n + 1];
        int[] dp = new int[k + 1];
        for(int i = 1;i <= n;i++) coins[i] = Integer.parseInt(br.readLine());
        for(int i = 1;i <= k;i++) dp[i] = Integer.MAX_VALUE - 1;

        for(int i = 1;i <= n;i++){
            for(int j = coins[i];j <= k;j++){
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        sb.append(dp[k] != Integer.MAX_VALUE - 1 ? dp[k] : -1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}