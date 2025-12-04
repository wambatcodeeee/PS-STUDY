import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        for(int i = 0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            if(i == 0){
                maxDp[0] = first;
                minDp[0] = first;
                maxDp[1] = second;
                minDp[1] = second;
                maxDp[2] = third;
                minDp[2] = third;
            }
            else{
                int recent0 = maxDp[0];
                int recent1 = maxDp[1];
                int recent2 = maxDp[2];
                maxDp[0] = Math.max(recent0, recent1) + first;
                maxDp[1] = Math.max(recent0, Math.max(recent1, recent2)) + second;
                maxDp[2] = Math.max(recent1, recent2) + third;

                recent0 = minDp[0];
                recent1 = minDp[1];
                recent2 = minDp[2];
                minDp[0] = Math.min(recent0, recent1) + first;
                minDp[1] = Math.min(recent0, Math.min(recent1, recent2)) + second;
                minDp[2] = Math.min(recent1, recent2) + third;
            }
        }


        sb.append(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]))).append(" ")
                .append(Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}