import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        long[] array = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++) array[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(array);

        int left, mid, right;
        long minSum = Long.MAX_VALUE;
        int[] liquid = new int[3];

        for(int i = 0;i <= N - 3;i++){
            left = i;
            mid = left + 1;
            right = N - 1;

            while(mid < right){
                long current = array[left] + array[mid] + array[right];
                if(minSum > Math.abs(current)) {
                    minSum = Math.abs(current);
                    liquid[0] = left;
                    liquid[1] = mid;
                    liquid[2] = right;
                }
                if(current > 0) right--;
                else if(current < 0) mid++;
                else break;
            }
        }

        sb.append(array[liquid[0]]).append(" ").append(array[liquid[1]]).append(" ").append(array[liquid[2]]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}