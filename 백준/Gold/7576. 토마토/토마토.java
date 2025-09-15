import java.io.*;
import java.util.*;
import java.util.Queue;

class Tomato{
    int row;
    int col;
    int day;

    public Tomato(int x, int y, int day){
        this.row = x;
        this.col = y;
        this.day = day;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Queue<Tomato> queue = new LinkedList<>();
    static int[][] visited;
    static int width, height;
    static int[] dr = {0, 1, -1, 0};
    static int[] dc = {1, 0, 0, -1};
    static int result = 0;

    public static void BFS(){
        while(!queue.isEmpty()){
            Tomato current = queue.poll();
            result = current.day;

            for(int i = 0;i < 4;i++){
                int nr = current.row + dr[i];
                int nc = current.col + dc[i];

                if(nr >= 0 && nr < height && nc >= 0 && nc < width){
                    if(visited[nr][nc] == 0){
                        visited[nr][nc] = 1;
                        queue.add(new Tomato(nr, nc, current.day + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        visited = new int[height][width];

        for(int i = 0;i < height;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < width;j++){
                visited[i][j] = Integer.parseInt(st.nextToken());
                if(visited[i][j] == 1) queue.add(new Tomato(i, j, 0));
            }
        }

        BFS();

        for(int i = 0;i < height;i++){
            for(int j = 0;j < width;j++){
                if (visited[i][j] == 0) {
                    result = -1;
                    break;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}