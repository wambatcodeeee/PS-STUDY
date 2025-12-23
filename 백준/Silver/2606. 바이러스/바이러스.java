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
        if(fa != fb) parent[fb] = fa;
    }

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int result = 0;
        parent = new int[N + 1];
        for(int i = 1;i <= N;i++) parent[i] = i;

        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            union(start, end);
        }

        for(int i = 2;i <= N;i++) if(find(parent[i]) == find(parent[1])) result++;
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}