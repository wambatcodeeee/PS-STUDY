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
            int length = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][length];
            int[][] dp = new int[2][length];

            for(int i = 0;i < 2;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j < length;j++) sticker[i][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            if(length > 1){
                dp[0][1] = sticker[1][0] + sticker[0][1];
                dp[1][1] = sticker[0][0] + sticker[1][1];
            }

            for(int i = 2;i < length;i++){
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }

            sb.append(Math.max(dp[0][length - 1], dp[1][length - 1])).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}