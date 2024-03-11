import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] array1 = new int[num1];

        for(int i = 0;i < num1;i++){
            array1[i] = Integer.parseInt(st.nextToken());
        }

        int num2 = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] array2 = new int[num2];

        for(int i = 0;i < num2;i++){
            array2[i] = Integer.parseInt(st1.nextToken());
        }

        for(int i:array2){
            boolean flag = false;
            for(int j:array1){
                if(i==j){
                    flag = true;
                    bw.write("1" + "\n");
                    break;
                }
            }
            if(!flag){
                bw.write("0" + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
