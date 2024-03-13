import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] numArray = new int[num];
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < num;i++){
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        for(int i:numArray){
            boolean prime = true;

            if(i == 1){
                continue;
            }

            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i % j == 0){
                    prime = false;
                    break;
                }
            }

            if(prime){
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
