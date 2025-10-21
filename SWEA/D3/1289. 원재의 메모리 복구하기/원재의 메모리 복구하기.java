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

        while (testCase-- > 0) {
            String memory = br.readLine();
            char[] reset = new char[memory.length()];
            Arrays.fill(reset, '0');
            int result = 0;

            int index = 0;
            while(!memory.equals(new String(reset))){
                if(memory.charAt(index) != reset[index]){
                    Arrays.fill(reset, index, reset.length, memory.charAt(index));
                    result++;
                }
                index++;
            }

            sb.append("#").append(level).append(" ").append(result).append("\n");
            level++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}