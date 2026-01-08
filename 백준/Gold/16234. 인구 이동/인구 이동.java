import java.util.*;
import java.io.*;
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
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> queue;
    static ArrayList<Node> arrayList;

    public static void BFS(){
        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i = 0;i < 4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]){
                    int diff = Math.abs(map[current.y][current.x] - map[ny][nx]);
                    if(L <= diff && R >= diff){
                        visited[ny][nx] = true;
                        queue.offer(new Node(nx, ny));
                        arrayList.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int result = 0;

        for(int i = 0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            boolean flag = false;
            visited = new boolean[N][N];
            for(int i = 0;i < N;i++){
                for(int j = 0;j < N;j++){
                    if(!visited[i][j]){
                        queue = new ArrayDeque<>();
                        arrayList = new ArrayList<>();
                        visited[i][j] = true;
                        queue.offer(new Node(j, i));
                        arrayList.add(new Node(j, i));
                        BFS();

                        if(arrayList.size() > 1){
                            flag = true;
                            int sum = 0;
                            for(Node n : arrayList) sum += map[n.y][n.x];

                            int avg = sum / arrayList.size();
                            for(Node n : arrayList) map[n.y][n.x] = avg;
                        }
                    }
                }
            }
            if(!flag) break;
            result++;
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}