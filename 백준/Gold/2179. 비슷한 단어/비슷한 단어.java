import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String[] words = new String[num];
        String word1 = "";
        String word2 = "";
        int prefixLength = Integer.MIN_VALUE;

        for(int i = 0; i < num; i++){
            words[i] = br.readLine();
        }

        for(int i = 0; i < num; i++){
            for(int j = i + 1; j < num; j++){
                int min = Math.min(words[i].length(), words[j].length());
                int current = 0;

                for(int k = 0; k < min; k++){
                    if(words[i].charAt(k) != words[j].charAt(k)) break;
                    current++;
                }

                if(current > prefixLength){
                    prefixLength = current;
                    word1 = words[i];
                    word2 = words[j];
                }
            }
        }

        bw.write(word1 + "\n");
        bw.write(word2 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
