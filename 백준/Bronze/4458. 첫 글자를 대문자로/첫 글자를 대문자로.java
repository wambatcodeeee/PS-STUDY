import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i < num;i++){
            char[] chars = br.readLine().toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            for(char c:chars){
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
