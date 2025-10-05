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
    static int width, height, result;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void BFS(){
        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i = 0;i < 8;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < width && ny >= 0 && ny < height){
                    if(!visited[ny][nx] && map[ny][nx] == 1){
                        visited[ny][nx] = true;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            if(width == 0 && height == 0) break;

            map = new int[height][width];
            visited = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        visited[i][j] = true;
                        queue.add(new Node(j, i));
                        BFS();
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");
            result = 0;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}