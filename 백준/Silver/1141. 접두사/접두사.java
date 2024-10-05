import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String[] wordArray = new String[num];
        for(int i = 0; i < num; i++){
            wordArray[i] = br.readLine();
        }

        Arrays.sort(wordArray);

        int count = 0;

        for(int i = 0; i < num; i++){
            boolean check = i + 1 < num && wordArray[i + 1].startsWith(wordArray[i]);
            if(!check) count++;
        }

        System.out.println(count);
    }
}
