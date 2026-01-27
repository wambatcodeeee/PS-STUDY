import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int result = Integer.MIN_VALUE;
        int[] array = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++) array[i] = Integer.parseInt(st.nextToken());
        dp[0] = array[0];

        for(int i = 1;i < n;i++) dp[i] = Math.max(dp[i - 1] + array[i], Math.max(array[i], array[i] + array[i - 1]));
        for(int i : dp) result = Math.max(result, i);
        
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}