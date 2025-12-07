import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        Arrays.fill(dp[0], 1);

        for(int i = 1;i <= N;i++){
            for(int j = 0;j < 10;j++){
                for(int m = j;m < 10;m++){
                    dp[i][j] += dp[i - 1][m] % 10007;
                }
            }
        }

        sb.append(dp[N][0] % 10007);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
