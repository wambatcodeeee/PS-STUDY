import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];

        for(int i = 1;i <= N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j <= N;j++) map[i][j] = Integer.parseInt(st.nextToken()) + map[i][j - 1];
        }

        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int result = 0;
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1;j <= x2;j++) result = map[j][y2] - map[j][y1 - 1] + result;
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}