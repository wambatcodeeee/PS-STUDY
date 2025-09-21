import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void solution(int[] array, int number)throws IOException {
        int result = 0;

        for(int i = 0;i < array.length - 2;i++){
            for(int j = i + 1;j < array.length - 1;j++){
               for(int m = j + 1;m < array.length;m++){
                   int sum = array[i] + array[j] + array[m];
                   if(sum == number) {
                       result = sum;
                       break;
                   }

                   if(sum < number && result < sum) result = sum;
               }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int card = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        int[] array = new int[card];

        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < card;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(array, number);
        bw.flush();
        bw.close();
        br.close();
    }
}