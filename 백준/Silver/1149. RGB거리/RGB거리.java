import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] dy;

    public static int solution() {
        for(int i = 1;i < N;i++){
            dy[i][0] += Math.min(dy[i - 1][1], dy[i - 1][2]);
            dy[i][1] += Math.min(dy[i - 1][0], dy[i - 1][2]);
            dy[i][2] += Math.min(dy[i - 1][0], dy[i - 1][1]);
        }

        return Math.min(Math.min(dy[N - 1][0], dy[N - 1][1]), dy[N - 1][2]);
    }


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dy = new int[N][3];

        for(int i = 0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < 3;j++){
                dy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(solution()));
        bw.flush();
        bw.close();
        br.close();
    }
}