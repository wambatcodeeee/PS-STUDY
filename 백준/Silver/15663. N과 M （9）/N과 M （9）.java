import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] pm, visited;
    static Set<String> set = new LinkedHashSet<>();
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void DFS(int L) throws IOException {
        if(L == M){
            String str = "";
            for(int i : pm) str += i + " ";
            set.add(str);

        }else {
            for(int i = 0;i < N;i++){
                if(visited[i] == 0){
                    visited[i] = 1;
                    pm[L] = arrayList.get(i);
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

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrayList);
        DFS(0);

        for(String s : set){
            bw.write(s);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}