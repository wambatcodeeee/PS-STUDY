import java.io.*;
import java.util.*;
import java.util.Queue;

class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int M, N, extent = 1;
    static boolean[][] visited;
    static int[][] map;
    static Queue<Node> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void BFS(){
        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i = 0;i < 4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                    if(!visited[ny][nx] && map[ny][nx] == 1){
                        visited[ny][nx] = true;
                        queue.add(new Node(nx, ny));
                        extent++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];
        int count = 0, result = 0;

        for(int i = 0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                if(!visited[i][j] && map[i][j] == 1){
                    visited[i][j] = true;
                    queue.add(new Node(j, i));
                    BFS();
                    count++;
                    result = Math.max(result, extent);
                    extent = 1;
                }
            }
        }

        sb.append(count).append("\n").append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}