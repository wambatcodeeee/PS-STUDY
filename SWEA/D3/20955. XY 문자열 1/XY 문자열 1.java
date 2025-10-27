import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        int level = 1;

        while(testCase-- > 0){
            String S = br.readLine();
            String E = br.readLine();

            while(S.length() != E.length()){
                StringBuilder sb1 = new StringBuilder();
                if(E.charAt(E.length() - 1) == 'X') E = E.substring(0, E.length() - 1);
                else E = sb1.append(E, 0, E.length() - 1).reverse().toString();
            }

            sb.append("#").append(level).append(" ").append(S.equals(E) ? "Yes" : "No").append("\n");
            level++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}