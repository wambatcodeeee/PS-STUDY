import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String result;
    static String N;
    static char[] array;
    static boolean[] visited;

    public static void DFS(StringBuilder sb1, int L){
        if(result.equals("possible")) return;
        if(L == N.length()){
            int num = Integer.parseInt(sb1.toString());
            if(num > Integer.parseInt(N) && num % Integer.parseInt(N) == 0) result = "possible";
            return;
        }
        char previous = 0;
        for(int i = 0;i < N.length();i++){
            if(visited[i]) continue;
            if(array[i] == previous) continue;
            if(L == 0 && array[i] == '0') continue;
            visited[i] = true;
            sb1.append(array[i]);
            DFS(sb1, L + 1);
            visited[i] = false;
            sb1.deleteCharAt(sb1.length() - 1);
            previous = array[i];
        }
    }

    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1;t <= testCase;t++) {
            sb.append("#").append(t).append(" ");
            N = br.readLine();
            array = N.toCharArray();
            visited = new boolean[N.length()];
            Arrays.sort(array);
            result = "impossible";

            DFS(new StringBuilder(), 0);

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
