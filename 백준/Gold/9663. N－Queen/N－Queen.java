import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, result;
    static int[] map;

    public static void DFS(int L){
        if(L == N) result++;
        else{
            for(int i = 0;i < N;i++){
                boolean flag = true;
                map[L] = i;
                for(int j = 0;j < L;j++){
                    if(map[L] == map[j] || Math.abs(L - j) == Math.abs(map[L] - map[j])){
                        flag = false;
                        break;
                    }
                }
                if(flag) DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        result = 0;
        DFS(0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}