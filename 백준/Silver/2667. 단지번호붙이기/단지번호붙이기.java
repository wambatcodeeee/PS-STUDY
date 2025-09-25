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
    static int N, houseNum;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static int[] houses;
    static Queue<Node> queue = new LinkedList<>();

    public static void BFS() throws IOException {
        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i = 0;i < 4;i++){
                int nx = current.col + dx[i];
                int ny = current.row + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(!visited[ny][nx] && 1 == map[ny][nx]){
                        visited[ny][nx] = true;
                        queue.offer(new Node(ny, nx));
                        houses[houseNum]++;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        map = new int[N][N];
        houses = new int[25 * 25];

        for(int i = 0;i < N;i++){
            String str = br.readLine();
            for(int j = 0;j < N;j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        for(int i = 0;i < N;i++){
            for(int j = 0;j < N;j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    queue.offer(new Node(i, j));
                    houseNum++;
                    houses[houseNum]++;
                    BFS();
                }
            }
        }

        bw.write(String.valueOf(houseNum));
        bw.newLine();
        Arrays.sort(houses);

        for (int house : houses) {
            if (house != 0) {
                bw.write(String.valueOf(house));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}