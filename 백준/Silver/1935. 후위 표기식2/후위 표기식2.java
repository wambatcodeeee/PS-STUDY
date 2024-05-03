import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Stack;

public class Main {
    private static double calculator(double num1, double num2, char operator) {
        switch(operator){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Double> stack = new Stack<>();

        int num = Integer.parseInt(br.readLine());

        String postfix = br.readLine();

        int[] values = new int[num];
        for(int i = 0; i < num; i++){
            values[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < postfix.length(); i++){
            char c = postfix.charAt(i);
            if(Character.isAlphabetic(c)) {
                stack.push((double) values[c - 'A']);
            }else{
                double num2 = stack.pop();
                double num1 = stack.pop();
                double result = calculator(num1, num2, c);
                stack.push(result);
            }
        }

        sb.append(String.format("%.2f", stack.pop()));

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();
    }
}
