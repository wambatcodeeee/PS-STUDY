import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;
    static int[] array;
    static int result;

    public static void DFS(int L, int index){
        if(L > K) return;
        if(index == array.length){
            if(L == K) result++;
        }
        else{
            DFS(L + array[index], index + 1);
            DFS(L, index + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        int level = 1;

        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            array = new int[N];
            result = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0;i < N;i++) array[i] = Integer.parseInt(st.nextToken());

            DFS(0, 0);
            sb.append("#").append(level).append(" ").append(result).append("\n");
            level++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}