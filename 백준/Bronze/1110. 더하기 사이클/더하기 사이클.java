import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int result = 0;
        int copy = num;

        do {
            int first = copy / 10;
            int second = copy % 10;

            copy = second * 10 + (first + second) % 10;

            result++;
        } while (num != copy);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
