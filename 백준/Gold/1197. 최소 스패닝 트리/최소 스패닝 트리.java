import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;
    static int result;

    public static int find(int v){
        if(v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    public static void union(Edge e){
        int fa = find(e.v1);
        int fb = find(e.v2);
        if(fa != fb) {
            parent[fb] = fa;
            result += e.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        ArrayList<Edge> arrayList = new ArrayList<>();

        for(int i = 1;i <= V;i++) parent[i] = i;
        for(int i = 0;i < E;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arrayList.add(new Edge(v1, v2, cost));
        }

        Collections.sort(arrayList);
        for(Edge e : arrayList) union(e);

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}