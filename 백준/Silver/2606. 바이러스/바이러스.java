import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static int node;
    static int result = 0;

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[node + 1];
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();
            for(int x : arr[now]){
                if(!visited[x]){
                    visited[x] = true;
                    result++;
                    q.add(x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        arr = new ArrayList[node + 1];
        for (int i = 1; i <= node; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i <= line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        bfs(1);
        System.out.println(result);
    }
}
