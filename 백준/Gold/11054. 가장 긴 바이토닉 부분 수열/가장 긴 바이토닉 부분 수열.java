import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N + 1];
        int[] dp1 = new int[N + 1];
        int[] dp2 = new int[N + 1];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1;i <= N;i++) array[i] = Integer.parseInt(st.nextToken());

        for(int i = 1;i <= N;i++){
            dp1[i] = 1;
            for(int j = 1;j < i;j++){
                if(array[i] > array[j]) {
                    dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                }
            }
        }

        for(int i = N;i >= 1;i--){
            dp2[i] = 1;
            for(int j = N;j > i;j--){
                if(array[i] > array[j]){
                    dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
                }
            }
        }

        for(int i = 1;i <= N;i++) max = Math.max(dp1[i] + dp2[i], max);
        sb.append(max - 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}