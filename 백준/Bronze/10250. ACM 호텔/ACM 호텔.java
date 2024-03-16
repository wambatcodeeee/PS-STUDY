import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String hotel(int length, int width, int guest){
        for(int i = 1;i <= width;i++){
            for(int j = 1;j <= length;j++){
                guest--;
                if(guest == 0){
                    return i < 10 ? j + "0" + i : String.valueOf(j) + i;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = 0;
        int width = 0;
        int guest = 0;

        int num = Integer.parseInt(br.readLine());

        for(int i = 0;i < num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                length = Integer.parseInt(st.nextToken());
                width = Integer.parseInt(st.nextToken());
                guest = Integer.parseInt(st.nextToken());
            }
            if(i == num-1) bw.write(hotel(length, width, guest));
            else bw.write(hotel(length, width, guest) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
