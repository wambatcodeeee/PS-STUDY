import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        String sentence = br.readLine();
        String explode = br.readLine();

        char lastExplode = explode.charAt(explode.length() - 1);

        char[] senArr = sentence.toCharArray();

        if(sentence.length() < explode.length()){
            bw.write(sentence);
        }else {
            for(char c:senArr){
                stack.push(c);

                boolean check = false;
                if(c == lastExplode && stack.size() >= explode.length()){
                    for(int i = 0;i < explode.length();i++){
                        if (stack.get(stack.size() - explode.length() + i) != explode.charAt(i)) {
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        for(int j = 0;j < explode.length();j++){
                            stack.pop();
                        }
                    }
                }
            }

            if(stack.isEmpty()) bw.write("FRULA");
            else{
                for(char c:stack){
                    bw.write(String.valueOf(c));
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
