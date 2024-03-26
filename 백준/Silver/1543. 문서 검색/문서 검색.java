import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String question = br.readLine();
        String check = br.readLine();
        int count = 0;

        while(question.contains(check)){
            int index = question.indexOf(check);
            question = question.substring(index + check.length());
            count++;
        }

        System.out.print(count);
    }
}
