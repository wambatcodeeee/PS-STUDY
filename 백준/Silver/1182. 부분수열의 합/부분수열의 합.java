import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, S;
    static int[] array;
    static int count;

    public static void DFS(int L, int M) throws IOException {
        if(N == L) {
            if(M == S){
                count++;
            }
            return;
        }

        DFS(L + 1, M + array[L]);
        DFS(L + 1, M);
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        if(S == 0) bw.write(String.valueOf(count - 1));
        else bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}