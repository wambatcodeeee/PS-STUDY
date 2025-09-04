import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void solution(long[] array) throws IOException {
        int lt = 0, rt = array.length - 1;
        long result = Long.MAX_VALUE;
        int ans_lt = 0, ans_rt = 0;

        while(lt < rt){;
            if(Math.abs(array[lt] + array[rt]) < result) {
                result = Math.abs(array[lt] + array[rt]);
                ans_lt = lt;
                ans_rt = rt;
            }
            if(array[lt] + array[rt] > 0) rt--;
            else if(array[lt] + array[rt] < 0)lt++;
            else if(array[lt] + array[rt] == 0) break;
        }

        sb.append(array[ans_lt]).append(" ").append(array[ans_rt]);
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        long[] array = new long[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < num;i++){
            array[i] = Long.parseLong(st.nextToken());
        }

        solution(array);

        bw.close();
        br.close();
    }
}