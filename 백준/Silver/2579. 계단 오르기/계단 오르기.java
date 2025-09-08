import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void solution(int num, int[] array, int[] dp) throws IOException {
        dp[1] = array[1];
        if(num >= 2) dp[2] = array[1] + array[2];

        for(int i = 3;i <= num;i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + array[i-1]) + array[i];
        }

        bw.write(String.valueOf(dp[num]));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num + 1];
        int[] dp = new int[num + 1];
        for(int i = 1;i <= num;i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        solution(num, array, dp);

        bw.close();
        br.close();
    }
}