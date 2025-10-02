import java.io.*;
import java.util.*;

class Node{
    int vertex;
    int distance;

    public Node(int vertex, int weight){
        this.vertex = vertex;
        this.distance = weight;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Node>> arrayList = new ArrayList<>();
    static int[] dist;
    static int start, end;
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
    static int result = 0;

    public static void dijkstra() throws IOException {
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int current_vertex = current.vertex;
            int current_distance = current.distance;

            if(current_vertex == end) {
                result = current_distance;
                break;
            }

            for(Node n : arrayList.get(current_vertex)){
                int cost = n.distance + dist[current_vertex];
                if(cost < dist[n.vertex]){
                    dist[n.vertex] = cost;
                    pq.offer(new Node(n.vertex, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i = 0;i <= N;i++){
            arrayList.add(new ArrayList<>());
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arrayList.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}