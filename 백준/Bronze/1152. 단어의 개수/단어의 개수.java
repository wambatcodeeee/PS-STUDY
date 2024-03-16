import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = br.readLine();

        StringTokenizer st = new StringTokenizer(sentence);

        bw.write(String.valueOf(st.countTokens()));
        bw.flush();
        bw.close();
        br.close();
    }
}
