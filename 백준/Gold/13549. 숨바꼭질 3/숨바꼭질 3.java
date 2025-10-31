import java.io.*;
import java.util.*;

class Node{
    int pos;
    int time;

    public Node(int pos, int time){
        this.pos = pos;
        this.time = time;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K, result = Integer.MAX_VALUE;
    static boolean[] visited;
    static int max = 100000;
    static Deque<Node> deque = new ArrayDeque<>();

    public static void BFS(){
        while(!deque.isEmpty()){
            Node current = deque.poll();
            visited[current.pos] = true;

            if(current.pos == K) {
                result = Math.min(result, current.time);
                break;
            }
            
            if(current.pos * 2 <= max && !visited[current.pos * 2]) deque.offerFirst(new Node(current.pos * 2, current.time));
            if(current.pos + 1 <= max && !visited[current.pos + 1]) deque.offerLast(new Node(current.pos + 1, current.time + 1));
            if(current.pos - 1 >= 0 && !visited[current.pos - 1]) deque.offerLast(new Node(current.pos - 1, current.time + 1));
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[max + 1];
        visited[N] = true;
        deque.offer(new Node(N, 0));
        BFS();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}