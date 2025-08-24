import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void solution(int[] array1, int[] array2) throws IOException {
        int p1 = 0, p2 = 0;

        while (p1 < array1.length && p2 < array2.length){
            if(array1[p1] < array2[p2]) {
                sb.append(array1[p1++]).append(" ");
            }

            else sb.append(array2[p2++]).append(" ");
        }

        while(array1.length > p1)  sb.append(array1[p1++]).append(" ");
        while(array2.length > p2)  sb.append(array2[p2++]).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int[] array1 = new int[num1];
        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < num1;i++){
            array1[i] = Integer.parseInt(st.nextToken());
        }

        int[] array2 = new int[num2];
        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < num2;i++){
            array2[i] = Integer.parseInt(st.nextToken());
        }

        solution(array1, array2);
        bw.close();
        br.close();
    }
}