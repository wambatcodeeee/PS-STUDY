import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dist;

    public static void Dijkstra(int cx, int cy){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N][N];
        for(int i = 0;i < N;i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[cx][cy] = map[cx][cy];
        pq.add(new Node(cx, cy, dist[cx][cy]));

        while(!pq.isEmpty()){
            Node current = pq.poll();

            if(current.cost <= dist[current.x][current.y]){
                for(int i = 0;i < 4;i++){
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                        int nCost = dist[current.x][current.y] + map[nx][ny];

                        if(nCost < dist[nx][ny]){
                            dist[nx][ny] = nCost;
                            pq.offer(new Node(nx, ny, nCost));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        int testCase = 1;

        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            map = new int[N][N];
            for(int i = 0;i < N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j < N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Dijkstra(0, 0);
            sb.append("Problem ").append(testCase).append(": ").append(dist[N - 1][N - 1]).append("\n");
            testCase++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}