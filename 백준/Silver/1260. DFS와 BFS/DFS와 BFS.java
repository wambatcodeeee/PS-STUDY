import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static List<Integer> dfsList;
    private static List<Integer> bfsList;

    public static void bfs(int start) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            bfsList.add(node);

            for(int neighbor : graph[node]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        dfsList.add(node);

        for(int neighbor : graph[node]){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfsList = new ArrayList<>();
        dfs(V);

        visited = new boolean[N + 1];
        bfsList = new ArrayList<>();
        bfs(V);

        for(int node : dfsList){
            bw.write(node + " ");
        }

        bw.write("\n");

        for(int node : bfsList){
            bw.write(node + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
