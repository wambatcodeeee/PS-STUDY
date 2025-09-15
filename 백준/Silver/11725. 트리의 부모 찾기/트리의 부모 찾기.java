import java.io.*;
import java.util.*;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;

    public static void BFS(int L){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(L);
        visited[L] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int i : tree.get(current)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    parent[i] = current;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        visited = new boolean[num + 1];
        parent = new int[num + 1];

        for(int i = 0;i < num + 1;i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0;i < num - 1;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            tree.get(first).add(second);
            tree.get(second).add(first);
        }

        BFS(1);

        for(int i = 2;i <= num;i++){
            bw.write(String.valueOf(parent[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}