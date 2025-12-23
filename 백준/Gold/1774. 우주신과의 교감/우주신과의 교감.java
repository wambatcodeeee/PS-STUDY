import java.util.*;
import java.io.*;

class God {
    int index;
    double x;
    double y;

    public God(int index, double x, double y){
        this.index = index;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    double cost;

    public Edge(int v1, int v2, double cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    public int compareTo(Edge o){
        return Double.compare(this.cost, o.cost);
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static God[] parent;
    static double result;

    public static int find(int v){
        if(v == parent[v].index) return v;
        return parent[v].index = find(parent[v].index);
    }

    public static void union(Edge e){
        int fa = find(e.v1);
        int fb = find(e.v2);
        if(fa != fb) {
            parent[fb].index = fa;
            result += e.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new God[n + 1];
        ArrayList<Edge> arrayList = new ArrayList<>();

        for(int i = 1;i <= n;i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            parent[i] = new God(i, x, y);
        }

        for(int i = 1;i <= m;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            union(new Edge(v1, v2, 0.0));
        }

        for(int i = 1;i <= n - 1;i++){
            God current1 = parent[i];
            int index1 = current1.index;
            double x1 = current1.x;
            double y1 = current1.y;
            for(int j = i + 1;j <= n;j++){
                God current2 = parent[j];
                int index2 = current2.index;
                double x2 = current2.x;
                double y2 = current2.y;
                double cost = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

                if(find(index1) != find(index2)) arrayList.add(new Edge(index1, index2, cost));
            }
        }

        Collections.sort(arrayList);
        for(Edge e : arrayList) union(e);

        sb.append(String.format("%.2f", result));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}