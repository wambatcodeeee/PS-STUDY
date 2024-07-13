import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<int[]> deque = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            while(!deque.isEmpty() && deque.peekFirst()[1] < i - L + 1){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && deque.peekLast()[0] >= array[i]){
                deque.pollLast();
            }

            deque.offerLast(new int[]{array[i], i});
            sb.append(deque.peekFirst()[0]).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
