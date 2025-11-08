import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
    'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1;t <= testCase;t++){
            sb.append("#").append(t).append(" ");
            char[] chars = br.readLine().toCharArray();
            int count = 0;
            int index = 0;
            while(index < chars.length){
                if(chars[index] == alphabet[index]) count++;
                else break;
                index++;
            }

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}