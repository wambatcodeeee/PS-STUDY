import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        if(num == 4 || num == 7){
            bw.write("-1");
        }else if(num % 5 == 0){
            bw.write(String.valueOf(num / 5));
        }else if(num % 5 == 1 || num % 5 == 3){
            bw.write(String.valueOf(num / 5 + 1));
        }else{
            bw.write(String.valueOf(num / 5 + 2));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}