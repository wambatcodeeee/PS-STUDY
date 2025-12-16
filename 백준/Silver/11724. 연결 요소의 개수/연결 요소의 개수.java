import java.util.*;
import java.io.*;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, result;
    static ArrayList<ArrayList<Integer>> arrayList;
    static Queue<Integer> queue;
    static boolean[] visited;

    public static void BFS(int num){
        queue = new LinkedList<>();
        queue.offer(num);
        visited[num] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i : arrayList.get(current)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();
        visited = new boolean[N + 1];
        result = 0;

        for(int i = 0;i <= N;i++) arrayList.add(new ArrayList<>());
        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrayList.get(start).add(end);
            arrayList.get(end).add(start);
        }

        for(int i = 1;i <= N;i++){
            if(!visited[i]){
                result++;
                BFS(i);
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}