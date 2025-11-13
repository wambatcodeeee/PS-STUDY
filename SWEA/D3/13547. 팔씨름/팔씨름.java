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
            String S = br.readLine();
            char[] chars = new char[15];
            Arrays.fill(chars, 'o');
            int count = 0;

            for(int i = 0;i < S.length();i++) chars[i] = S.charAt(i);
            for(char c : chars) if(c == 'o') count++;
            sb.append(count >= 8 ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
