import java.io.*;

public class Main {
    static String ios = "I";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        String sentence = br.readLine();
        int count = 0;

        for(int i = 0;i < repeat;i++){
            ios += "OI";
        }

        while(sentence.contains(ios)){
            int index = sentence.indexOf(ios);
            count++;
            index += 1;
            sentence = sentence.substring(index);
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
