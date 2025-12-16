import java.util.*;
import java.io.*;
import java.util.Queue;

class Node{
    int x;
    int y;
    int count;

    public Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[][] visited;
    static int[][] map;
    static int I, result;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int startX, startY, endX, endY;
    static Queue<Node> pq;

    public static void BFS(){
        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(current.x == endX && current.y == endY){
                result = current.count;
                break;
            }

            for(int i = 0;i < 8;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < I && ny >= 0 && ny < I){
                    if(!visited[ny][nx]){
                        pq.add(new Node(nx, ny, current.count + 1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 0;t < testCase;t++){
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];
            pq = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            pq.offer(new Node(startX, startY, 0));
            visited[startY][startX] = true;
            BFS();

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}