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
        int[] cases = new int[num];

        for (int i = 0; i < num; i++) {
            cases[i] = Integer.parseInt(br.readLine());
        }

        int max = 40;
        int[] fibonacciZero = new int[max + 1];
        int[] fibonacciOne = new int[max + 1];

        fibonacciZero[0] = 1;
        fibonacciZero[1] = 0;

        fibonacciOne[0] = 0;
        fibonacciOne[1] = 1;

        for (int i = 2; i <= max; i++) {
            fibonacciZero[i] = fibonacciZero[i-1] + fibonacciZero[i-2];
            fibonacciOne[i] = fibonacciOne[i-1] + fibonacciOne[i-2];
        }

        for (int i = 0; i < num; i++) {
            int n = cases[i];
            bw.write(fibonacciZero[n] + " " + fibonacciOne[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
