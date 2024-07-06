import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[][] lectures = new int[num][2];

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i][0] = start;
            lectures[i][1] = end;
        }

        Arrays.sort(lectures, Comparator.comparingInt(o -> o[0]));
        queue.add(lectures[0][1]);

        for(int i = 1; i < num; i++){
            if(lectures[i][0] >= queue.peek()) queue.poll();
            queue.add(lectures[i][1]);
        }

        bw.write(String.valueOf(queue.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
