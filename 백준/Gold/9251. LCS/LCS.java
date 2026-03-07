import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int[][] dp = new int[str1.length + 1][str2.length + 1];

        for(int i = 1;i <= str1.length;i++){
            for(int j = 1;j <= str2.length;j++){
                if(str1[i - 1] == str2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        bw.write(String.valueOf(dp[str1.length][str2.length]));
        bw.flush();
        bw.close();
        br.close();
    }
}