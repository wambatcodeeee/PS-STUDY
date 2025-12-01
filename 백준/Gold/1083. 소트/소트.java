import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++) array[i] = Integer.parseInt(st.nextToken());

        int S = Integer.parseInt(br.readLine());
        for(int i = 0;i < N;i++){
            if(S == 0) break;
            int maxNum = array[i];
            int maxNumIdx = i;

            for(int j = i + 1;j < N;j++){
                if(S >= j - i && array[j] > maxNum){
                    maxNum = array[j];
                    maxNumIdx = j;
                }
            }

            for(int m = maxNumIdx;m > i;m--){
                int temp = array[m];
                array[m] = array[m - 1];
                array[m - 1] = temp;
            }

            S -= maxNumIdx - i;
        }

        for(int i : array) sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}