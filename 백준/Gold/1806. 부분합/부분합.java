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
        int S = Integer.parseInt(st.nextToken());
        int[] array = new int[N + 1];
        int result = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++) array[i] = Integer.parseInt(st.nextToken());

        int start = 0, end = 0, sum = 0;
        while(start <= end && end <= N){
            if(sum < S) {
                sum += array[end];
                end++;
            } else{
              result = Math.min(result, end - start);
              sum -= array[start];
              start++;
            }
        }

        sb.append(result == Integer.MAX_VALUE ? 0 : result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}