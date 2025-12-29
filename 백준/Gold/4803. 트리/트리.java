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

    public static void union(int v1, int v2){
        int fv1 = find(v1);
        int fv2 = find(v2);
        if(fv1 != fv2) parent[fv2] = fv1;
    }

    public static void main(String[] args) throws IOException{
        int testCase = 1;
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int result = 0;
            if(n == 0 && m == 0) break;
            parent = new int[n + 1];
            boolean[] checkTree = new boolean[n + 1];
            for(int i = 1;i <= n;i++) checkTree[i] = true;
            for(int i = 1;i <= n;i++) parent[i] = i;
            for(int i = 0;i < m;i++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int fv1 = find(v1);
                int fv2 = find(v2);
                if(fv1 == fv2) checkTree[fv1] = false;
                else {
                    union(v1, v2);
                    checkTree[fv1] = checkTree[fv1] && checkTree[fv2];
                }
            }

            for(int i = 1;i <= n;i++){
                if(parent[i] == i && checkTree[i]) result++;
            }

            if(result == 0) sb.append("Case ").append(testCase).append(": ").append("No trees.").append("\n");
            else if(result == 1) sb.append("Case ").append(testCase).append(": ").append("There is one tree.").append("\n");
            else sb.append("Case ").append(testCase).append(": ").append("A forest of ").append(result).append(" trees.").append("\n");
            testCase++;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}