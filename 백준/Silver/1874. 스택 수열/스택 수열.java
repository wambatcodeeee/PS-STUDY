import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack1 = new Stack<>();
        int order = Integer.parseInt(br.readLine());
        int[] orderArr = new int[order];
        int pointer = 0;

        for (int i = 0; i < order; i++) {
            orderArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= order; i++) {
            stack1.push(i);
            sb.append("+" + "\n");

            while (!stack1.isEmpty() && stack1.peek() == orderArr[pointer]) {
                stack1.pop();
                sb.append("-" + "\n");
                pointer++;
            }
        }

        if (stack1.isEmpty()) {
            bw.write(sb.toString());
        } else {
            bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}