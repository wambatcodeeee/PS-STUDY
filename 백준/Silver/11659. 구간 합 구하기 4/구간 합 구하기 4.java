import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int test_case = Integer.parseInt(st.nextToken());
        int[] array = new int[num + 1];
        array[0] = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 1;i <= num;i++){
            array[i] = Integer.parseInt(st.nextToken()) + array[i - 1];
        }

        for(int i = 0;i < test_case;i++){
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            bw.write((array[back] - array[front - 1]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
