import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        String str = br.readLine();
        boolean flag = true;

        char checkChar = str.charAt(0);
        for(char c : str.toCharArray()){
            if(c != checkChar){
                flag = false;
                break;
            }
        }

        if(flag){
            System.out.println("-1");
            return;
        }
        else{
            if(str.contentEquals(sb.append(str).reverse())) bw.write(String.valueOf(str.length() - 1));
            else bw.write(String.valueOf(str.length()));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}