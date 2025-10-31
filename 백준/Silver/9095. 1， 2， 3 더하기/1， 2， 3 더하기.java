import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1;t <= testCase;t++){
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];

            dp[1] = 1;
            if(n > 1) dp[2] = 2;
            if(n > 2) dp[3] = 4;

            for(int i = 4;i <= n;i++) dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}