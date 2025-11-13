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
            int min = Integer.parseInt(new String(chars)), max = Integer.parseInt(new String(chars));

            for(int i = 0;i < chars.length - 1;i++){
                for(int j = i + 1;j < chars.length;j++){
                    if(i == 0 && chars[j] == '0') continue;
                    char temp;
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;

                    min = Math.min(Integer.parseInt(new String(chars)), min);
                    max = Math.max(Integer.parseInt(new String(chars)), max);

                    chars[j] = chars[i];
                    chars[i] = temp;
                }
            }

            sb.append(min).append(" ").append(max).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
