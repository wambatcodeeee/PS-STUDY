import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int num = 1;

        while(count > 0){
            String check = String.valueOf(num);
            if(check.contains("666")){
                count--;
                if(count == 0){
                    bw.write(check);
                }
            }
            num++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
