import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;

    public static int find(int v){
        if(v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) parent[fa] = fb;
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for(int i = 0;i <= n;i++) parent[i] = i;
        for(int i = 0;i < m;i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(flag == 0) union(a, b);
            else sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}