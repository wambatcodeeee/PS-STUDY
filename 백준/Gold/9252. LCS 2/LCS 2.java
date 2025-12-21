import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int[][] dp = new int[str1.length + 1][str2.length + 1];
        StringBuilder result = new StringBuilder();

        for(int i = 1;i <= str1.length;i++){
            for(int j = 1;j <= str2.length;j++){
                if(str1[i - 1] == str2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int row = str1.length;
        int col = str2.length;

        while(row != 0 && col != 0){
            if(str1[row - 1] == str2[col - 1]) {
                result.append(str1[row - 1]);
                row--;
                col--;
            }
            else if(dp[row - 1][col] >= dp[row][col - 1]) row--;
            else col--;
        }

        sb.append(dp[str1.length][str2.length]).append("\n");
        if(result.length() != 0) sb.append(result.reverse());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}