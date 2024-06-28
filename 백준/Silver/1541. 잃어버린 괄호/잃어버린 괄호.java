import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");

        int result = 0;
        boolean check = true;

        while(minus.hasMoreTokens()){
            String current = minus.nextToken();
            StringTokenizer plus = new StringTokenizer(current, "+");
            int sum = 0;

            while(plus.hasMoreTokens()) sum += Integer.parseInt(plus.nextToken());

            if(check){
                result += sum;
                check = false;
            } else result -= sum;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
