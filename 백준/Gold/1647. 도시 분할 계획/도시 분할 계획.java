import java.util.*;
import java.io.*;

class Home implements Comparable<Home>{
    int v1;
    int v2;
    int cost;

    public Home(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    public int compareTo(Home o){
        return this.cost - o.cost;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;
    static int result = 0;
    static int max = 0;

    public static int find(int v){
        if(v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    public static void union(Home h){
        int fa = find(h.v1);
        int fb = find(h.v2);

        if(fa != fb){
            parent[fb] = fa;
            result += h.cost;
            max = Math.max(max, h.cost);
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        ArrayList<Home> arrayList = new ArrayList<>();
        for(int i = 1;i <= N;i++) parent[i] = i;
        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arrayList.add(new Home(v1, v2, cost));
        }
        Collections.sort(arrayList);

        for(int i = 0;i < M;i++){
            Home current = arrayList.get(i);
            union(current);
        }

        sb.append(result - max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}