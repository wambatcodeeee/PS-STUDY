import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String first = br.readLine();
        String second = br.readLine();

        while(second.length() > first.length()){
            if(second.charAt(second.length() - 1) == 'A') second = second.substring(0, second.length() - 1);
            else if(second.charAt(second.length() - 1) == 'B') second = new StringBuilder(second.substring(0, second.length() - 1)).reverse().toString();
        }

        if(first.equals(second)) bw.write("1" + "\n");
        else bw.write("0" + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
