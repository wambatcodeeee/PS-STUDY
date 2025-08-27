import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void solution(char[] chars) throws IOException {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        char previous = '0';

        for(char c : chars){
            if(c == '('){
                stack.push(c);
                previous = '(';
            } else {
                if(previous == '('){
                    stack.pop();
                    result += stack.size();
                    previous = ')';
                } else {
                    result++;
                    stack.pop();
                }
            }
        }

        bw.write(String.valueOf(result));
    }

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        char[] chars = str.toCharArray();

        solution(chars);
        bw.close();
        br.close();
    }
}