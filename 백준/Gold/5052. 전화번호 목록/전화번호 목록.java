import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0;i < num;i++){
            int num1 = Integer.parseInt(br.readLine());
            ArrayList<String> arrayList = new ArrayList<>();
            boolean flag = true;

            for(int j = 0;j < num1;j++){
                arrayList.add(br.readLine());
            }

            Collections.sort(arrayList);

            for(int j = 1;j < num1;j++){
                if(arrayList.get(j).startsWith(arrayList.get(j - 1))){
                    flag = false;
                    break;
                }
            }

            if(flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}