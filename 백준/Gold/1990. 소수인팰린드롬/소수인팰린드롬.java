import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean isPalindrome(int num){
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        return sb.toString().contentEquals(sb.reverse());
    }

    public static void solution(int start, int last) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean[] array = new boolean[last + 1];

        for(int i = 2;i * i <= last;i++){
            if(!array[i]){
                for(int n = i * i;n <= last;n += i){
                    array[n] = true;
                }
            }
        }

        for(int i = start;i <= last;i++){
            if(!array[i] && isPalindrome(i)) sb.append(i).append("\n");
        }

        sb.append("-1");
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());

        solution(start, last);
        bw.close();
        br.close();
    }
}