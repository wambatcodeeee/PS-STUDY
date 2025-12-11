import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;

    public static void DFS(int L, int count) throws IOException{
        if(N / 2 == count){
            int startOVR = 0;
            int linkOVR = 0;

            for(int i = 0;i < N - 1;i++){
                for(int j = i + 1;j < N;j++){
                    if(visited[i] && visited[j]){
                        startOVR += map[i][j];
                        startOVR += map[j][i];
                    }
                    else if(!visited[i] && !visited[j]){
                        linkOVR += map[i][j];
                        linkOVR += map[j][i];
                    }
                }
            }

            if(Math.abs(startOVR - linkOVR) == 0) {
                bw.write(String.valueOf(0));
                bw.flush();
                System.exit(0);
            }
            else result = Math.min(result, Math.abs(startOVR - linkOVR));
        }
        else{
            for(int i = L;i < N;i++){
                if(!visited[i]){
                    visited[i] = true;
                    DFS(i + 1, count + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        for(int i = 0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}