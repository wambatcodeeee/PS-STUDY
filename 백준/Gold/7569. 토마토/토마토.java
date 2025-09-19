import java.io.*;
import java.util.*;
import java.util.Queue;

class Tomato{
    int x;
    int y;
    int z;
    int day;

    public Tomato(int x, int y, int z, int day){
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }

}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] visited;
    static int M, N, H;
    static int result;
    static Queue<Tomato> queue = new LinkedList<>();

    public static void BFS() {
        while(!queue.isEmpty()){
            Tomato current = queue.poll();
            result = current.day;

            for(int i = 0;i < 6;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nz = current.z + dz[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H){
                    if(visited[nz][ny][nx] == 0){
                        visited[nz][ny][nx] = 1;
                        queue.add(new Tomato(nx, ny, nz, current.day + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        visited = new int[H][N][M];

        for(int i = 0;i < H;i++){
            for(int j = 0;j < N;j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0;k < M;k++){
                    visited[i][j][k] = Integer.parseInt(st.nextToken());
                    if(visited[i][j][k] == 1) queue.add(new Tomato(k, j, i, 0));
                }
            }
        }

        BFS();

        for(int i = 0;i < H;i++){
            for(int j = 0;j < N;j++){
                for(int k = 0;k < M;k++){
                    if (visited[i][j][k] == 0) {
                        result = -1;
                        break;
                    }
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}