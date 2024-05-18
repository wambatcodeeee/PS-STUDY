import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] campus = new char[N][M];
        int X = 0;
        int Y = 0;
        
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            
            for(int j = 0; j < M; j++){
                campus[i][j] = line.charAt(j);
                if(campus[i][j] == 'I'){
                    X = i;
                    Y = j;
                }
            }
        }

        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[] {X, Y});
        visited[X][Y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 0;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if(campus[x][y] == 'P'){
                count++;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && campus[nx][ny] != 'X'){
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        if(count > 0){
            bw.write(String.valueOf(count));
        }else{
            bw.write("TT");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
