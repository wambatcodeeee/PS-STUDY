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
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static char[][] map;
    static int N;
    static int result;
    static Queue<Node> queue = new LinkedList<>();

    public static void BFS() {
        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i = 0;i < 4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(!visited[nx][ny] && map[current.x][current.y] == map[nx][ny]){
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }

            if(map[current.x][current.y] == 'G') map[current.x][current.y] = 'R';
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new char[N][N];
        result = 0;

        for(int i = 0;i < N;i++){
            String str = br.readLine();
            for(int j = 0;j < N;j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0;i < N;i++){
            for(int j = 0;j < N;j++){
                if(!visited[i][j]){
                    result++;
                    visited[i][j] = true;
                    queue.offer(new Node(i, j));
                    BFS();
                }
            }
        }

        sb.append(result).append(" ");
        result = 0;
        visited = new boolean[N][N];

        for(int i = 0;i < N;i++){
            for(int j = 0;j < N;j++){
                if(!visited[i][j]){
                    result++;
                    visited[i][j] = true;
                    queue.offer(new Node(i, j));
                    BFS();
                }
            }
        }
        sb.append(result);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}