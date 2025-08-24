import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void solution(int[] liquid) throws IOException {
        int lp = 0, rp = liquid.length - 1;
        int min = Integer.MAX_VALUE;
        int answer_lp = 0;
        int answer_rp = 0;

        Arrays.sort(liquid);

        while(lp < rp){
            if(min > Math.abs(liquid[lp] + liquid[rp])) {
                min = Math.abs(liquid[lp] + liquid[rp]);
                answer_lp = liquid[lp];
                answer_rp = liquid[rp];
            }

            if(liquid[lp] + liquid[rp] > 0) rp--;
            else if(liquid[lp] + liquid[rp] < 0) lp++;
            else if(liquid[lp] + liquid[rp] == 0) break;
        }

        bw.write(answer_lp + " " + answer_rp);
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int[] liquid = new int[num];
        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < num;i++){
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        solution(liquid);
        bw.close();
        br.close();
    }
}