import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] chars = {'U', 'C', 'P', 'C'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;

        for(char c:str.toCharArray()){
            if(c == chars[count]) count++;
            if(count == 4) break;
        }

        if(count == 4) System.out.print("I love UCPC");
        else System.out.print("I hate UCPC");
    }
}
