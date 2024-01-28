import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static String Validator(int[] array){
        Stack<Integer> stack = new Stack<>();
        int min = 1;
        boolean check = true;

        for(int i = 0;i < array.length;i++){
            if(array[i] != min){
                if(!stack.isEmpty() && stack.peek() == min){
                    stack.pop();
                    min++;
                    i--;
                }else stack.push(array[i]);
            }else min++;
        }

        for(int i = 0;i < stack.size();i++){
            if(stack.pop() == min) min++;
            else{
                check = false;
                break;
            }
        }

        return check ? "Nice" : "Sad";
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int order = Integer.parseInt(br.readLine());
        int[] array = new int[order];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < order;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Validator(array));
        bw.flush();
        bw.close();
        br.close();
    }
}
