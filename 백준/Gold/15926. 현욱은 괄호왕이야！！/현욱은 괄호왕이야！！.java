import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = 0;i < chars.length;i++){
            if(chars[i] == '(') stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else max = Math.max(max, i - stack.peek());
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}