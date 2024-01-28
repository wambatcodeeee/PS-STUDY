import java.io.*;
import java.util.Stack;

public class Main {
    public static String Validator(String str){
        Stack<Character> stack = new Stack<>();
        char[] chrArray = str.toCharArray();
        for(char c:chrArray){
            if(c == '('){
                stack.push(c);
            } else if (c == ')') {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";


    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = Integer.parseInt(br.readLine());

        for(int i = 0;i < order;i++){
            String str = br.readLine();
            bw.write(Validator(str) + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
