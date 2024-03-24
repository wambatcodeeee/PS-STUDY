import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> arrayList = new ArrayList<>();

        String[] strings = br.readLine().split("");

        for (String string : strings) {
            arrayList.add(Integer.parseInt(string));
        }

        arrayList.sort(Collections.reverseOrder());

        for(int i:arrayList){
            bw.write(String.valueOf(i));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
