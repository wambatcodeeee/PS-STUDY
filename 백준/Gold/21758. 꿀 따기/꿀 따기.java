import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] honey = new int[N + 1];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1;i <= N;i++) honey[i] = Integer.parseInt(st.nextToken());

        int[] sum1 = new int[N + 2];
        int[] sum2 = new int[N + 2];

        for(int i = 1;i <= N;i++){
            sum1[i] = honey[i] + sum1[i - 1];
            sum2[N - i + 1] = honey[N - i + 1] + sum2[N - i + 2];
        }

        for(int i = 2;i <= N - 1;i++) result = Math.max(result, sum1[N] - sum1[1] - honey[i] + sum1[N] - sum1[i]);
        for(int i = N - 1;i >= 2;i--) result = Math.max(result, sum2[1] - sum2[N] - honey[i] + sum2[1] - sum2[i]);
        for(int i = 2;i <= N - 1;i++) result = Math.max(result, sum1[i] - sum1[1] + sum2[i] - sum2[N]);

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
