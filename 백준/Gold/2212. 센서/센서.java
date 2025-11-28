import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int[] distance = new int[N - 1];
        int result = 0;

        for(int i = 0; i < N; i++) array[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(array);
        
        for(int i = 0; i < N - 1; i++) distance[i] = array[i + 1] - array[i];
        Arrays.sort(distance);
        
        for(int i = 0; i < N - K; i++) result += distance[i];
        sb.append(result);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}