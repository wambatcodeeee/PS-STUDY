import java.util.*;
import java.io.*;

class Star {
    int index;
    double x;
    double y;

    public Star(int index, double x, double y){
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
    static Star[] parent;
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
        parent = new Star[n + 1];
        ArrayList<Edge> arrayList = new ArrayList<>();

        for(int i = 1;i <= n;i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            parent[i] = new Star(i, x, y);
        }

        for(int i = 1;i <= n;i++){
            Star current1 = parent[i];
            double x1 = current1.x;
            double y1 = current1.y;
            int index1 = current1.index;

            for(int j = i + 1;j <= n;j++){
                Star current2 = parent[j];
                double x2 = current2.x;
                double y2 = current2.y;
                int index2 = current2.index;

                arrayList.add(new Edge(index1, index2, Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))));
            }
        }

        Collections.sort(arrayList);
        for(Edge e : arrayList) union(e);

        sb.append(Math.round(result * 100) / 100.0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}