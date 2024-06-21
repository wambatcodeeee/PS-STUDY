import java.io.*;
import java.util.*;

public class Main {
    public static boolean isSnake(int x, int y, Deque<int[]> snake) {
        for(int[] position : snake){
            if(position[0] == x && position[1] == y){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<int[]> snake = new LinkedList<>();
        Map<Integer, Character> directions = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            directions.put(time, direction);
        }

        snake.add(new int[]{0, 0});
        int direction = 0;
        int seconds = 0;

        while(true){
            seconds++;
            int[] head = snake.peek();
            int headX = head[0] + dx[direction];
            int headY = head[1] + dy[direction];

            if(headX < 0 || headX >= n || headY < 0 || headY >= n || isSnake(headX, headY, snake)) break;

            snake.addFirst(new int[]{headX, headY});

            if(board[headX][headY] == 1) board[headX][headY] = 0;
            else snake.pollLast();

            if(directions.containsKey(seconds)){
                char turn = directions.get(seconds);
                if(turn == 'L') direction = (direction + 3) % 4;
                else direction = (direction + 1) % 4;
            }
        }

        bw.write(seconds + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
