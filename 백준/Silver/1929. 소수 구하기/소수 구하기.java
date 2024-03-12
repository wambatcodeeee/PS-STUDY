import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(st.nextToken());
        int num1 = Integer.parseInt(st.nextToken());

        boolean[] array = new boolean[num1+1];

        for(int i = 2;i <= num1;i++){
            if(array[i]) continue;
            else if(num <= i) sb.append(i).append("\n");
            for(int j = i + i;j <= num1;j += i){
                array[j] = true;
            }
        }
        
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
