import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        long[][] dp = new long[N + 1][N + 1];
        dp[1][1] = 1;

        for(int i = 1;i <= N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j <= N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1;i <= N;i++){
            for(int j = 1;j <= N;j++){
                if(map[i][j] == 0) break;
                if(map[i][j] + i <= N) dp[map[i][j] + i][j] += dp[i][j];
                if(map[i][j] + j <= N) dp[i][map[i][j] + j] += dp[i][j];
            }
        }
        
        sb.append(dp[N][N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}