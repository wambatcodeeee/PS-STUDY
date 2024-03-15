import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        int num = Integer.parseInt(br.readLine());
        int except = (int)Math.round(num * 0.15);
        double result = 0;

        for(int i = 0;i < num;i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for(int i = except;i < num - except;i++){
            result += list.get(i);
        }

        bw.write(String.valueOf(Math.round(result / (num - except * 2))));
        bw.flush();
        bw.close();
        br.close();
    }
}
