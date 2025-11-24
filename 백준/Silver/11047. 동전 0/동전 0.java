import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        for(int i = 0;i < N;i++) array[i] = Integer.parseInt(br.readLine());
        int count = 0;

        while(K > 0){
            int recent = 0;
            for(int i : array) {
                if(i > K) break;
                recent = i;
            }
            count += K / recent;
            K %= recent;
        }

        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}