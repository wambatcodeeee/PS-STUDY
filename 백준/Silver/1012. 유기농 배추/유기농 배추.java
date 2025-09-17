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
    static int[][] map;
    static int[][] ch;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int width, height, cabbage;

    public static void BFS(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        ch[x][y] = 1;
        queue.offer(new Node(x, y));

        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i = 0;i < 4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= width || ny >= height || nx < 0 || ny < 0) continue;
                if(map[nx][ny] != 1 || ch[nx][ny] == 1) continue;

                queue.add(new Node(nx, ny));
                ch[nx][ny] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());


        for(int i = 0;i < testCase;i++){
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            cabbage = Integer.parseInt(st.nextToken());
            map = new int[width][height];
            ch = new int[width][height];

            for(int j = 0;j < cabbage;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int result = 0;

            for(int m = 0;m < width;m++){
                for(int n = 0;n < height;n++){
                    if(map[m][n] == 1 && ch[m][n] != 1){
                        BFS(m, n);
                        result++;
                    }
                }
            }

            bw.write(String.valueOf(result));
            bw.flush();
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}