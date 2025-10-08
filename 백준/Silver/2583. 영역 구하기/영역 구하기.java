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
    static int M, N, K, count = 1;
    static boolean[][] visited;
    static int[][] map;
    static Queue<Node> queue = new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void BFS(){
        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i = 0;i < 4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visited[ny][nx] && map[ny][nx] == 0){
                        visited[ny][nx] = true;
                        queue.add(new Node(nx, ny));
                        count++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        map = new int[M][N];

        for(int i = 0;i < K;i++){
            st = new StringTokenizer(br.readLine());
            int firstX = Integer.parseInt(st.nextToken());
            int firstY = Integer.parseInt(st.nextToken());
            int secondX = Integer.parseInt(st.nextToken());
            int secondY = Integer.parseInt(st.nextToken());

            for(int j = firstY;j < secondY;j++){
                for(int h = firstX;h < secondX;h++){
                    map[j][h] = 1;
                }
            }
        }

        for(int i = 0;i < M;i++){
            for(int j = 0;j < N;j++){
                if(!visited[i][j] && map[i][j] == 0){
                    visited[i][j] = true;
                    queue.add(new Node(j, i));
                    BFS();
                    pq.offer(count);
                    count = 1;
                }
            }
        }

        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}