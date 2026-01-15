import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int V, E, K;
    static ArrayList<ArrayList<Node>> arrayList = new ArrayList<>();

    public static void Dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()){
            int current = pq.poll().index;
            if(!visited[current]){
                visited[current] = true;

                for(Node n : arrayList.get(current)){
                    if(dist[n.index] > dist[current] + n.cost){
                        dist[n.index] = dist[current] + n.cost;
                        pq.add(new Node(n.index, dist[n.index]));
                    }
                }
            }
        }

        for(int i = 1;i < dist.length;i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        for(int i = 0;i <= V;i++) arrayList.add(new ArrayList<>());
        for(int i = 0;i < E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arrayList.get(u).add(new Node(v, w));
        }

        Dijkstra();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}