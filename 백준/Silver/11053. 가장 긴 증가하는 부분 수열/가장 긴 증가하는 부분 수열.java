import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] dy, arr;

    public static int solution() {
        int result = 1;
        dy[0] = 1;

        for(int i = 1;i < N;i++){
            int max = 0;
            for(int j = i;j >= 0;j--) if(arr[i] > arr[j] && dy[j] > max) max = dy[j];
            dy[i] = max + 1;
            result = Math.max(result, dy[i]);
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dy = new int[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++) arr[i] = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(solution()));
        bw.flush();
        bw.close();
        br.close();
    }
}