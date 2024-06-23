import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> stack = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N];

        for(int i = 0; i < N; i++){
            height[i] = Integer.parseInt(br.readLine());
        }

        long result = 0;

        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && stack.peek() <= height[i]) stack.pop();
            stack.push(height[i]);
            result += stack.size() - 1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
