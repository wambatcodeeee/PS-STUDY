import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb1 = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++) array[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] array1 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < M;i++) array1[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        int N_Index = 0;
        int M_Index = 0;

        while(N_Index < N && M_Index < M){
            int max = 0;
            int tempN = -1;
            int tempM = -1;

            for(int i = N_Index;i < N;i++) {
                for(int j = M_Index;j < M;j++) {
                    if(array[i] == array1[j]) {
                        if(max < array[i]){
                            max = array[i];
                            tempN = i;
                            tempM = j;
                        }
                    }
                }
            }

            if(max != 0){
                count++;
                sb.append(max).append(" ");
                N_Index = ++tempN;
                M_Index = ++tempM;
            } else break;
        }

        sb1.append(count).append("\n").append(sb);
        bw.write(sb1.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}