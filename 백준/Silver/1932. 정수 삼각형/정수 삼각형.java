import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] dy, arr;

    public static int solution() {
        int result = 0;

        for(int i = 1;i <= N;i++){
            for(int j = 1;j <= N;j++){
                dy[i][j] = Math.max(dy[i - 1][j], dy[i - 1][j - 1]) + arr[i][j];
            }
        }
        for(int i = 1;i <= N;i++) result = Math.max(result, dy[N][i]);

        return result;
    }


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dy = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];

        for(int i = 1;i <= N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j <= i;j++){
                int current = Integer.parseInt(st.nextToken());
                arr[i][j] = current;
                dy[i][j] = current;
            }
        }

        bw.write(String.valueOf(solution()));
        bw.flush();
        bw.close();
        br.close();
    }
}