import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 1];
        int[] dp = new int[n + 1];

        for(int i = 1;i <= n;i++) array[i] = Integer.parseInt(br.readLine());

        dp[1] = array[1];
        if(n > 1) dp[2] = array[1] + array[2];
        for(int i = 3;i <= n;i++) dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + array[i], dp[i - 3] + array[i - 1] + array[i]));

        sb.append(dp[n]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}