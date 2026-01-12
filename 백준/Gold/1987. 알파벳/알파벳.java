import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C, result;
    static Set<Character> set;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;

    public static void DFS(int x, int y, int len){
        set.add(map[x][y]);
        result = Math.max(result, len);

        for(int i = 0;i < 4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C && !set.contains(map[nx][ny])) DFS(nx, ny, len + 1);
        }
        set.remove(map[x][y]);
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        set = new HashSet<>();

        for(int i = 0;i < R;i++){
            char[] chars = br.readLine().toCharArray();
            for(int j = 0;j < C;j++) map[i][j] = chars[j];
        }

        DFS(0, 0, 1);

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}