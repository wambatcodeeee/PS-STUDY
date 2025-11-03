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
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int count = 0;

            String[] array = new String[N];

            for(int i = 0;i < N;i++) {
                String current = br.readLine();
                array[i] = current;
                if(current.contentEquals(new StringBuilder(current).reverse())) flag = true;
            }

            for(int i = 0;i < N - 1;i++){
                for(int j = i + 1;j < N;j++) {
                    if(array[i].contentEquals(new StringBuilder(array[j]).reverse())) count++;
                }
            }

            sb.append(flag ? count * M * 2 + M : count * M * 2).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}