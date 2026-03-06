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
        int[] dp = new int[N + 1];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1;i <= N;i++) array[i] = Integer.parseInt(st.nextToken());

        for(int i = 1;i <= N;i++){
            for(int j = 0;j < i;j++){
                if(array[i] > array[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        sb.append(max).append("\n");

        int answer = max;
        Stack<Integer> stack = new Stack<>();
        for(int i = N;i >= 1;i--){
            if(answer == dp[i]){
                answer--;
                stack.push(array[i]);
            }
        }

        while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}