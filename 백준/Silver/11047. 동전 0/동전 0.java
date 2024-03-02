import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int totalMoney = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] coins = new int[num];

        for(int i = 0;i < num;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = num - 1;i >= 0;i--){
            if(totalMoney / coins[i] > 0){
                count += totalMoney / coins[i];
                totalMoney = totalMoney % coins[i];
            }
        }

        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}