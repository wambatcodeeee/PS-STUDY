import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;

    static int find(int v){
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);

        if(fa != fb) parent[fb] = fa;
    }

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for(int i = 1;i <= N;i++) parent[i] = i;
        for(int i = 0;i < N - 2;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        outer : for(int i = 1;i <= N;i++){
            for(int j = 1;j <= N;j++){
                if(find(i) != find(j)) {
                    sb.append(i).append(" ").append(j);
                    break outer;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}