import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1;t <= testCase;t++) {
            sb.append("#").append(t).append(" ");
            char[] chars = br.readLine().toCharArray();
            int result = 0;

            for(int i = 0;i < chars.length - 1;i++){
                if((chars[i] == '(' && chars[i + 1] == '|') || (chars[i] == '|' && chars[i + 1] == ')') ||
                chars[i] == '(' && chars[i + 1] == ')') result++;
            }

            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
