import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] pm, array;
    static Set<String> set = new LinkedHashSet<>();

    public static void DFS(int L, int S) throws IOException {
        if(L == M){
            String str = "";
            for(int i : pm){
                str += i + " ";
            }
            set.add(str);
        }else {
            for(int i = S;i < N;i++){
                pm[L] = array[i];
                DFS(L + 1, i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pm = new int[M];
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        DFS(0, 0);

        for(String s : set){
            bw.write(s);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}