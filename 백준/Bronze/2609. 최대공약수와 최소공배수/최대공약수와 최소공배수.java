import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int gcd(int num1, int num2){
        while(num2 > 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp%num2;
        }
        return num1;
    }

    public static int lcm(int num1, int num2){
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        int gcd = gcd(max, min);

        return (max*min) / gcd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        bw.write(gcd(Math.max(num1, num2), Math.min(num1, num2)) + "\n");
        bw.write(String.valueOf(lcm(num1, num2)));
        bw.close();
        br.close();
    }
}
