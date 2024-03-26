import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> arrayList = new ArrayList<>();

        String str = br.readLine();

        for(int i = 0;i < str.length();i++){
            arrayList.add(str.substring(i));
        }

        Collections.sort(arrayList);

        for(String s:arrayList){
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
