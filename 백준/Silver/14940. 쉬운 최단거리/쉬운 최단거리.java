import java.io.*;
import java.util.*;
import java.util.Queue;

class Node{
    int row;
    int col;

    public Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int height, width;
    static int startHeight, startWidth;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static Queue<Node> queue = new LinkedList<>();

    public static void BFS() throws IOException {
        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i = 0;i < 4;i++){
                int nx = current.col + dx[i];
                int ny = current.row + dy[i];

                if(nx >= 0 && nx < width && ny >= 0 && ny < height){
                    if(!visited[ny][nx] && map[ny][nx] == 1){
                        visited[ny][nx] = true;
                        map[ny][nx] = map[current.row][current.col] + 1;
                        queue.offer(new Node(ny, nx));
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        visited = new boolean[height][width];
        map = new int[height][width];

        for(int i = 0;i < height;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < width;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    startHeight = i;
                    startWidth = j;
                } else if(map[i][j] == 0) visited[i][j] = true;
            }
        }

        map[startHeight][startWidth] = 0;
        visited[startHeight][startWidth] = true;
        queue.offer(new Node(startHeight, startWidth));
        BFS();

        for(int i = 0;i < height;i++){
            for(int j = 0;j < width;j++){
                if(!visited[i][j]) map[i][j] = -1;
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}