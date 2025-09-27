import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] pm, visited, array;

    public static void DFS(int L) throws IOException {
        if(L == M){
            for(int i : pm){
                bw.write(i + " ");
            }
            bw.newLine();
        }else {
            for(int i = 0;i < N;i++){
                if(visited[i] == 0){
                    visited[i] = 1;
                    pm[L] = array[i];
                    DFS(L + 1);
                    visited[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pm = new int[M];
        visited = new int[N];
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        DFS(0);

        bw.flush();
        bw.close();
        br.close();
    }
}