import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        String line;

        while((line = br.readLine()) != null){
            if(line.contains("E-N-D")){
                break;
            }

            StringTokenizer tokenizer = new StringTokenizer(line, " .,?!:;\"'()[]{}<>*&^%$#@!`~|\\1234567890_+=/\t\n\r\f");

            while(tokenizer.hasMoreTokens()){
                String word = tokenizer.nextToken().toLowerCase();
                if(word.length() > str.length()){
                    str = word;
                }
            }
        }

        bw.write(str);
        bw.flush();
        bw.close();
        br.close();
    }
}
