import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] dy;

    public static int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        if(n > 2) for(int i = 3;i <= n;i++) dy[i] = (dy[i - 1] + dy[i - 2]) % 10007;

        return dy[n];
    }


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dy = new int[1005];

        bw.write(String.valueOf(solution(N)));
        bw.flush();
        bw.close();
        br.close();
    }
}