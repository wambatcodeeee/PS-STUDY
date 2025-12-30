import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] cost = new int[N + 1];
        int[] customer = new int[N + 1];
        int[] dp = new int[100001];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 1;i <= N;i++){
            st = new StringTokenizer(br.readLine());
            int currentCost = Integer.parseInt(st.nextToken());
            int currentCustomer = Integer.parseInt(st.nextToken());
            cost[i] = currentCost;
            customer[i] = currentCustomer;
        }

        for(int i = 1;i <= N;i++){
            for(int j = cost[i];j <= 100000;j++){
                if(dp[j - cost[i]] != -1) dp[j] = Math.max(dp[j], customer[i] + dp[j - cost[i]]);
            }
        }

        for(int i = 1;i <= 100000;i++){
            if(dp[i] >= C) {
                sb.append(i);
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}