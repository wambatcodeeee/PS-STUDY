import java.io.*;
import java.util.InputMismatchException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        int order = Integer.parseInt(br.readLine());

        for(int i = 0;i < order;i++){
            String[] str = br.readLine().split(" ");
            if(str[0].equals("0")){
                stack.pop();
                continue;
            }
            stack.push(Integer.parseInt(str[0]));
        }

        for (Integer integer : stack) {
            result += integer;
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
