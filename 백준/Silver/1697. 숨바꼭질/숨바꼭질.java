import java.io.*;
import java.util.*;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K, result;
    static int[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void BFS(){
        while(!queue.isEmpty()){
            int current = queue.poll();

            if(current == K) result = visited[current];
            if(current - 1 >= 0 && visited[current - 1] == 0){
                visited[current - 1] = visited[current] + 1;
                queue.add(current - 1);
            }
            if(current + 1 <= 100000 && visited[current + 1] == 0){
                visited[current + 1] = visited[current] + 1;
                queue.add(current + 1);
            }
            if(current * 2 <= 100000 && visited[current * 2] == 0){
                visited[current * 2] = visited[current] + 1;
                queue.add(current * 2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        queue.add(N);
        visited[N] = 1;
        BFS();

        bw.write(String.valueOf(result - 1));
        bw.flush();
        bw.close();
        br.close();
    }
}