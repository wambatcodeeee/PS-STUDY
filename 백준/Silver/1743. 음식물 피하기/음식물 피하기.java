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
    static boolean[][] visited;
    static int[][] map;
    static int col, row, trash;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result;
    static Queue<Node> queue = new LinkedList<>();

    public static void BFS() throws IOException {
        int count = 1;

        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i = 0;i < 4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < col && ny >= 0 && ny < row){
                    if(!visited[ny][nx] && map[ny][nx] == 1){
                        visited[ny][nx] = true;
                        queue.offer(new Node(nx, ny));
                        count++;
                    }
                }
            }
        }

        result = Math.max(result, count);
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        trash = Integer.parseInt(st.nextToken());
        visited = new boolean[row][col];
        map = new int[row][col];

        for(int j = 0;j < trash;j++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1;
        }


        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(!visited[i][j] && map[i][j] == 1){
                    visited[i][j] = true;
                    queue.offer(new Node(j, i));
                    BFS();
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}