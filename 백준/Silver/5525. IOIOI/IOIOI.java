import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        char[] sentence = br.readLine().toCharArray();

        int result = 0;

        for (int i = 0; i < sentence.length - 2; i++) {
            if (sentence[i] == 'I' && sentence[i + 1] == 'O' && sentence[i + 2] == 'I') {
                int count = 0;
                while (i < sentence.length - 2 && sentence[i] == 'I' && sentence[i + 1] == 'O' && sentence[i + 2] == 'I') {
                    count++;
                    i += 2;
                }
                result += Math.max(0, count - repeat + 1);
            }
        }

        System.out.println(result);
    }
}