import java.io.*;
import java.util.*;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, R;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] resultArray;

    public static void BFS(){
        int count = 0;
        resultArray[R] = ++count;
        visited[R] = true;
        queue.add(R);

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i = 0;i < arrayList.get(current).size();i++){
                int n = arrayList.get(current).get(i);
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                    resultArray[n] = ++count;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        resultArray = new int[N + 1];

        for(int i = 0;i <= N;i++) arrayList.add(new ArrayList<>());

        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arrayList.get(start).add(end);
            arrayList.get(end).add(start);
        }

        for(int i = 1;i <= N;i++) Collections.sort(arrayList.get(i));
        BFS();

        for(int i = 1;i <= N;i++) bw.write(resultArray[i] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}