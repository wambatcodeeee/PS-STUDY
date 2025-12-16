import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int INF = 1000000000;
    static int[][] map;
    static int n, m;

    public static void solution(){
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= n;j++){
                for(int k = 1;k <= n;k++) {
                    if(map[j][i] != INF && map[i][k] != INF) map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);

                }
            }
        }

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= n;j++){
                if(map[i][j] == INF) sb.append(0).append(" ");
                else sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= n;j++){
                if(i == j) continue;
                map[i][j] = INF;
            }
        }

        for(int i = 0;i < m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(map[start][end], cost);
        }

        solution();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}