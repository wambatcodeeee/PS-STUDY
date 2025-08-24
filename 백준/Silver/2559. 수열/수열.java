import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void solution(int continous, int[] record) throws IOException {
        int answer;
        int max = 0;

        for(int i = 0;i < continous;i++) max += record[i];
        answer = max;

        for(int i = continous;i < record.length;i++){
            max = max - record[i - continous] + record[i];
            answer = Integer.max(answer, max);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int days = Integer.parseInt(st.nextToken());
        int continous = Integer.parseInt(st.nextToken());
        int[] record = new int[days];

        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < days;i++){
            record[i] = Integer.parseInt(st.nextToken());
        }

        solution(continous, record);
        bw.close();
        br.close();
    }
}