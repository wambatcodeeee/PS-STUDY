import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, result;
    static ArrayList<ArrayList<Integer>> arrayList;
    static boolean[] visited;

    public static void DFS(int node, int length){
        visited[node] = true;
        result = Math.max(length, result);

        for(int i : arrayList.get(node)) if(!visited[i]) DFS(i, length + 1);
        visited[node] = false;
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        int level = 1;

        while(testCase-- > 0) {
            arrayList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;

            for(int i = 0;i <= N;i++) arrayList.add(new ArrayList<>());

            for(int i = 0;i < M;i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                arrayList.get(start).add(end);
                arrayList.get(end).add(start);
            }

            for(int i = 1;i <= N;i++){
                visited = new boolean[N + 1];
                DFS(i, 1);
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