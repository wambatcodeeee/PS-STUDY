import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static long[] array;

    public static boolean checking(long num){
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        return Long.parseLong(new String(chars)) == num;
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        int level = 1;

        while (testCase-- > 0) {
            N = Integer.parseInt(br.readLine());
            array = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i < N;i++) array[i] = Integer.parseInt(st.nextToken());
            boolean flag = false;

            long result = 0;

            for(int i = 0;i < N;i++){
                for(int j = i + 1;j < N;j++){
                    if(checking(array[i] * array[j])) {
                        result = Math.max(result, array[i] * array[j]);
                        flag = true;
                    }
                }
            }
            
            sb.append("#").append(level).append(" ").append(flag ? result : -1).append("\n");
            level++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}