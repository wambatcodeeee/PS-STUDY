import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = 10;

        while(testCase-- > 0){
            int level = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) deque.add(Integer.parseInt(st.nextToken()));

            while(deque.peekLast() > 0){
                for(int i = 1;i <= 5;i++){
                    int current = deque.pollFirst() - i;
                    if(current <= 0) {
                        deque.add(0);
                        break;
                    } else deque.add(current);
                }
            }
            sb.append("#").append(level).append(" ");
            for(int i : deque) sb.append(i).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}