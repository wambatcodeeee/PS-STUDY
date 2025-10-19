import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String current = br.readLine();
            char[] fillL = current.replace('?', 'L').toCharArray();
            char[] fillR = current.replace('?', 'R').toCharArray();
            int max = 0;

            int distance = 0;
            for(char c : fillL){
                if(c == 'L') distance--;
                else if(c == 'R') distance++;
                max = Math.max(max, Math.abs(distance));
            }

            distance = 0;
            for(char c : fillR){
                if(c == 'L') distance--;
                else if(c == 'R') distance++;
                max = Math.max(max, Math.abs(distance));
            }

            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}