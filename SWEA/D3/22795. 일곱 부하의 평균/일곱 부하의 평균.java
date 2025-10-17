import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0){
            st = new StringTokenizer(br.readLine());
            int max = 0;
            int sum = 0;
            for(int i = 0;i < 6;i++) {
                int current = Integer.parseInt(st.nextToken());
                max = Math.max(max, current);
                sum += current;
            }

            int result = max + 1;
            while((sum + result) % 7 != 0) result++;

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}