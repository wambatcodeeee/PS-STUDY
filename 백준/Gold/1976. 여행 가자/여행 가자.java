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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] course = new int[M];
        parent = new int[N + 1];
        for(int i = 1;i <= N;i++) parent[i] = i;
        for(int i = 1;i <= N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j <= N;j++){
                int connect = Integer.parseInt(st.nextToken());
                if(connect == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < M;i++) course[i] = Integer.parseInt(st.nextToken());

        boolean flag = true;
        for(int i = 0;i < M - 1;i++){
            if(find(course[i]) != find(course[i + 1])) flag = false;
        }

        sb.append(flag ? "YES" : "NO");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}