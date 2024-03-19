import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken()), popNum = Integer.parseInt(st.nextToken());
        int index = 0;

        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i = 1;i <= num;i++){
            linkedList.add(i);
        }
        
        sb.append("<");

        while(num > 1){
            index = (index + (popNum - 1)) % num;
            sb.append(linkedList.remove(index)).append(", ");
            num--;
        }

        sb.append(linkedList.remove()).append(">");

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
