import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] pm;

    public static void DFS(int L, int S) throws IOException {
        if(L == M){
            for(int i : pm){
                bw.write(i + " ");
            }
            bw.newLine();
        }else {
            for(int i = S;i <= N;i++){
                pm[L] = i ;
                DFS(L + 1, i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pm = new int[M];

        DFS(0, 1);

        bw.flush();
        bw.close();
        br.close();
    }
}