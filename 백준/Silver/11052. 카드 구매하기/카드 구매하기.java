import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N + 1];
        int[] dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1;i <= N;i++) array[i] = Integer.parseInt(st.nextToken());
        for(int i = 1;i <= N;i++) for(int j = 1; j <= i; j++) dp[i] = Math.max(dp[i], dp[i - j] + array[j]);
        sb.append(dp[N]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}