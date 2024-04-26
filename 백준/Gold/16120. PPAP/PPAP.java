import java.io.*;
import java.util.Stack;

public class Main {
    static Stack<String> stack = new Stack<>();
    static String ppap = "PPAP";
    static void ppaping(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 4;i++){
            sb.insert(0, stack.pop());
        }

        if(String.valueOf(sb).equals(ppap)) stack.push("P");
        else for(int i = 0;i < 4;i++){
            stack.push(String.valueOf(String.valueOf(sb).charAt(i)));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        for(int i = 0;i < str.length();i++){
            stack.push(String.valueOf(str.charAt(i)));

            if(stack.size() >= 4){
                ppaping();
            }
        }

        bw.write(stack.size() == 1 && stack.peek().equals("P") ? "PPAP" : "NP");
        bw.flush();
        bw.close();
        br.close();
    }
}
