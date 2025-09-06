import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void solution(long num1, long num2) throws IOException {
        int result = 1;
        long target = num2;

        while(target != num1){
            if(target < num1) {
                bw.write("-1");
                bw.flush();
                System.exit(0);
            }
            if(target % 2 == 0) target /= 2;
            else if(target % 10 == 1) target /= 10;
            else{
                bw.write("-1");
                bw.flush();
                System.exit(0);
            }
            result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        bw.close();
        br.close();
    }
}