import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        Integer[] array = new Integer[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++) array[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(array, Collections.reverseOrder());

        for(int i = 0;i < N;i++){
            if(pq.size() >= M) result = pq.poll();
            pq.add(result + array[i]);
        }

        while(!pq.isEmpty()) result = pq.poll();

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}