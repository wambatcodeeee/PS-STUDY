import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            int num = Integer.parseInt(br.readLine());
            long[] prices = new long[num];
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < num; j++){
                prices[j] = Long.parseLong(st.nextToken());
            }

            long profit = 0;
            long price = 0;

            for(int j = num - 1; j >= 0; j--){
                if(prices[j] > price) price = prices[j];
                else profit += price - prices[j];
            }

            sb.append(profit).append("\n");
        }

        System.out.print(sb);
    }
}
