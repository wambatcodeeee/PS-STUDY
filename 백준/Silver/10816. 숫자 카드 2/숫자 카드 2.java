import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int card = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cardNum = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < card;i++){
            int key = Integer.parseInt(st.nextToken());

            if(!cardNum.containsKey(key)) cardNum.put(key, 1);
            else cardNum.put(key, cardNum.get(key) + 1);
        }

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < num;i++){
            int target = Integer.parseInt(st.nextToken());
            if(cardNum.containsKey(target)) sb.append(cardNum.get(target)).append(" ");
            else sb.append("0").append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
