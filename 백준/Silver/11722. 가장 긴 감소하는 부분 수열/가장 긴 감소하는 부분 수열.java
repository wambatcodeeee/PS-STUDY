import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = N - 1;i >= 0;i--) array[i] = Integer.parseInt(st.nextToken());
        dp[0] = 1;
        int result = 1;

        for(int i = 1;i < N;i++){
            int max = 0;
            for(int j = i;j >= 0;j--) if(array[j] < array[i] && dp[j] > max) max = dp[j];
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}