import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, answer = Integer.MIN_VALUE;

    static void swap(char[][] map, int x1, int y1, int x2, int y2){
        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    static void checkMax(char[][] map){
        for(int i = 0;i < N;i++){
            int count = 1;
            for(int j = 1;j < N;j++){
                if(map[i][j - 1] == map[i][j]) count++;
                else count = 1;
                answer = Math.max(answer, count);
            }
        }

        for(int i = 0;i < N;i++){
            int count = 1;
            for(int j = 1;j < N;j++){
                if(map[j - 1][i] == map[j][i]) count++;
                else count = 1;
                answer = Math.max(answer, count);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for(int i = 0;i < N;i++){
            String str = br.readLine();
            for(int j = 0;j < N;j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0;i < N;i++){
            for(int j = 0;j < N;j++){
                if(j + 1 < N){
                    swap(map, i, j, i, j + 1);
                    checkMax(map);
                    swap(map, i, j, i, j + 1);
                }

                if(i + 1 < N){
                    swap(map, i, j, i + 1, j);
                    checkMax(map);
                    swap(map, i, j, i + 1, j);
                }
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}