import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    int distance;

    public Node(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int compareTo(Node o){
        if(this.distance == o.distance && this.x == o.x) return this.y - o.y;
        else if(this.distance == o.distance) return this.x - o.x;
        return this.distance - o.distance;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, result;
    static int sharkBig = 2, needToEat = 2;
    static int currentX, currentY;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int BFS(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(currentX, currentY, 0));
        visited = new boolean[N][N];
        visited[currentX][currentY] = true;

        while(!pq.isEmpty()){
            Node current = pq.poll();

            if(map[current.x][current.y] > 0 && map[current.x][current.y] < sharkBig){
                map[current.x][current.y] = 0;
                currentX = current.x;
                currentY = current.y;
                return current.distance;
            }

            for(int i = 0;i < 4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(map[nx][ny] > sharkBig) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                pq.offer(new Node(nx, ny, current.distance + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        result = 0;
        map = new int[N][N];
        for(int i = 0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    currentX = i;
                    currentY = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true){
            int time = BFS();
            if(time == -1) break;

            result += time;
            needToEat--;
            if(needToEat == 0){
                sharkBig++;
                needToEat = sharkBig;
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}