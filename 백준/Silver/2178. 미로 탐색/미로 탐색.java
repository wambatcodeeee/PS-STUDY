import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] maze;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs(int X, int Y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{X, Y});
        visited[X][Y] = true;
        distance[X][Y] = 1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX >= 0 && newX < N && newY >= 0 && newY < M){
                    if(maze[newX][newY] == 1 && !visited[newX][newY]){
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        distance[newX][newY] = distance[x][y] + 1;
                    }
                }
            }
        }
        return distance[N-1][M-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
