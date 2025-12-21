import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;

    public static int find(int v){
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) parent[fb] = fa;
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        boolean flag = false;
        parent = new int[n];
        for(int i = 0;i < n;i++) parent[i] = i;
        for(int i = 0;i < m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(find(start) == find(end)) {
                flag = true;
                break;
            }
            else{
                union(start, end);
                result++;
            }
        }

        sb.append(flag ? result + 1 : 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}