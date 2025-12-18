import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int INF = 1000000000;
    static int[][] map;
    static int[] items;
    static int n, m, r, result;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        result = 0;
        map = new int[n + 1][n + 1];
        items = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1;i <= n;i++) items[i] = Integer.parseInt(st.nextToken());

        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= n;j++){
                if(i == j) continue;
                map[i][j] = INF;
            }
        }

        for(int i = 0;i < r;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(map[start][end], distance);
            map[end][start] = Math.min(map[end][start], distance);
        }

        for(int k = 1;k <= n;k++){
            for(int i = 1;i <= n;i++){
                for(int j = 1;j <= n;j++){
                    if(map[i][k] != INF && map[k][j] != INF) map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for(int i = 1;i <= n;i++){
            int count = 0;
            for(int j = 1;j <= n;j++){
                if(map[i][j] <= m) count += items[j];
            }
            result = Math.max(result, count);
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}