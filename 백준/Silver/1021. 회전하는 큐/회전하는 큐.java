import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] array = new int[M];

        for(int i = 1;i <= N;i++) deque.offer(i);
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < M;i++) array[i] = Integer.parseInt(st.nextToken());

        int idx = 0;
        while(!deque.isEmpty() && idx < M){
            if(deque.peek() == array[idx]) {
                deque.poll();
                idx++;
            }
            else{
                int target = 0;
                for(int n : deque){
                    if(n == array[idx]) break;
                    target++;
                }

                if(deque.size() / 2 >= target){
                    int pollNum = deque.poll();
                    deque.offer(pollNum);
                    answer++;
                }
                else{
                    int pollNum = deque.pollLast();
                    deque.offerFirst(pollNum);
                    answer++;
                }
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}