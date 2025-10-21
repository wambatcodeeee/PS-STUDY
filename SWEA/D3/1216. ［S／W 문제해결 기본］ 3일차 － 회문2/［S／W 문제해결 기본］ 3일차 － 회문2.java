import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = 10;

        while (testCase-- > 0) {
            int num = Integer.parseInt(br.readLine());
            char[][] chars = new char[100][100];
            int result = 0;

            for (int i = 0; i < 100; i++) {
                char[] c = br.readLine().toCharArray();
                for (int j = 0; j < 100; j++) chars[i][j] = c[j];
            }

            for(int i = 0;i < 100;i++){
                for(int j = 0;j < 100;j++){
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder tmp = new StringBuilder();
                    for(int k = j;k < 100;k++){
                        tmp.append(chars[i][k]);
                        sb1.append(chars[i][k]);
                        if(tmp.toString().contentEquals(new StringBuilder(sb1).reverse().toString())) result = Math.max(result, tmp.length());
                    }
                }
            }

            for(int i = 0;i < 100;i++){
                for(int j = 0;j < 100;j++){
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder tmp = new StringBuilder();
                    for(int k = j;k < 100;k++){
                        tmp.append(chars[k][i]);
                        sb1.append(chars[k][i]);
                        if(tmp.toString().contentEquals(new StringBuilder(sb1).reverse().toString())) result = Math.max(result, tmp.length());
                    }
                }
            }

            sb.append("#").append(num).append(" ").append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}