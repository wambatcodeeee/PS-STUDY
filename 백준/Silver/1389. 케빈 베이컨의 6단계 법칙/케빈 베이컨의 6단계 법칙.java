import java.io.*;
import java.util.*;
import java.util.Queue;

class Node{
    int index;
    int count;
    
    public Node(int index, int count){
        this.index = index;
        this.count = count;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, result = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    public static void BFS(int num){
        visited = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();
        visited[num] = true;
        queue.add(new Node(num, 0));

        int sum = 0;
        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i = 0;i < arrayList.get(current.index).size();i++){
                int n = arrayList.get(current.index).get(i);
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(new Node(n, current.count + 1));
                    sum += current.count + 1;
                }
            }
        }

        if(min > sum){
            min = sum;
            result = num;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0;i <= N;i++) arrayList.add(new ArrayList<>());

        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arrayList.get(A).add(B);
            arrayList.get(B).add(A);
        }

        for(int i = 1;i <= N;i++) BFS(i);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}