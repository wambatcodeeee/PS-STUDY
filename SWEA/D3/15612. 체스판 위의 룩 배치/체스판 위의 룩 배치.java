import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1;t <= testCase;t++){
            sb.append("#").append(t).append(" ");
            char[][] map = new char[8][8];
            boolean flag = true;
            int rookCnt = 0;

            for(int i = 0;i < 8;i++){
                String str = br.readLine();
                for(int j = 0;j < 8;j++) {
                    map[i][j] = str.charAt(j);
                    if(str.charAt(j) == 'O') rookCnt++;
                }
            }

            for(int i = 0;i < 8;i++){
                int count1 = 0;
                int count2 = 0;
                for(int j = 0;j < 8;j++) {
                    if(map[i][j] == 'O') count1++;
                    if(map[j][i] == 'O') count2++;
                }
                if(count1 > 1 || count2 > 1){
                    flag = false;
                    break;
                }
            }

            sb.append(rookCnt == 8 && flag ? "yes" : "no").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}