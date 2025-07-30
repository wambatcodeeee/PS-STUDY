import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void solution(int start, int last) throws IOException {
        int[] array = new int[start + last + 1];

        for(int i = 2;i <= last;i++){
            if(array[i] == 0){
                for(int n = i;n <= last;n += i){
                    array[n] = 1;
                }
                if(i >= start) bw.write(i + "\n");
            }
        }
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