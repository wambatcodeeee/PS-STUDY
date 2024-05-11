import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        int pipe = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '(')stack.push(c);
            else{
                stack.pop();
                if(str.charAt(i - 1) == '(') pipe += stack.size();
                else pipe++;
            }
        }

        bw.write(pipe + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
