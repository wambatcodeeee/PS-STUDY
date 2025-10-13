import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N, result;
    static int[] map;

    public static void DFS(int L){
        if(L == N) result++;
        else{
            for(int i = 0;i < N;i++){
                map[L] = i;
                boolean flag = true;
                for(int j = 0;j < L;j++)
                    if (map[j] == map[L] || Math.abs(L - j) == Math.abs(map[L] - map[j])) {
                        flag = false;
                        break;
                    }
                if(flag) DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        int level = 1;

        while(testCase-- > 0){
            N = Integer.parseInt(br.readLine());
            map = new int[N];
            result = 0;
            DFS(0);

            sb.append("#").append(level).append(" ").append(result).append("\n");
            level++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}