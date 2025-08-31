import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void solution(Deque<Integer> deque) throws IOException {
        while(deque.size() > 1){
            deque.pollFirst();
            deque.add(deque.pollFirst());
        }

        bw.write(String.valueOf(deque.pollFirst()));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 1;i <= num;i++){
            deque.add(i);
        }
        solution(deque);

        bw.close();
        br.close();
    }
}