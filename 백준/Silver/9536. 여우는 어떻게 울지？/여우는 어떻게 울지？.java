import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        for(int i = 0;i < num;i++){
            StringBuilder sb = new StringBuilder();
            ArrayList<String> arrayList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) arrayList.add(st.nextToken());

            while(true){
                String lyric = br.readLine();
                if(lyric.equals("what does the fox say?")) break;
                StringTokenizer st1 = new StringTokenizer(lyric);
                st1.nextToken();
                st1.nextToken();
                String sound = st1.nextToken();
                arrayList.removeIf(s -> s.equals(sound));
            }

            for(int j = 0;j < arrayList.size();j++){
                if(j == arrayList.size() - 1) sb.append(arrayList.get(j));
                else sb.append(arrayList.get(j)).append(" ");
            }
            bw.write(String.valueOf(sb));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}