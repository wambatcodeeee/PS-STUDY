import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        boolean flag = false;
        int len = sentence.length();
        for(int i = 0; i < len / 2; i++) {
            if(sentence.charAt(i) != sentence.charAt(len-i-1)) {
                System.out.println(sentence.length());
                return;
            }else if(sentence.charAt(i) != sentence.charAt(i+1)) {
                flag = true;
            }

        }
        if(flag) {
            System.out.println(sentence.length()-1);
        }else {
            System.out.println(-1);
        }
    }
}