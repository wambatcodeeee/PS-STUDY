import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        while(true){
            String str = br.readLine();
            if(str.equals("0")) break;

            sb = new StringBuilder(str);
            String reverse = String.valueOf(sb.reverse());

            if(str.equals(reverse)) bw.write("yes" + "\n");
            else bw.write("no" + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
