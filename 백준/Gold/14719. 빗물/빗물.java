import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[W];
        for(int i = 0;i < W;i++) array[i] = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        int answer = 0;

        for(int i = 0;i < W;i++){
            while(!deque.isEmpty() && array[deque.peekFirst()] < array[i]){
                int current = deque.pop();
                if(deque.isEmpty()) break;
                int first = deque.peekFirst();
                int width = i - first - 1;
                int h = Math.min(array[first], array[i]) - array[current];
                answer += width * h;
            }

            deque.push(i);
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}