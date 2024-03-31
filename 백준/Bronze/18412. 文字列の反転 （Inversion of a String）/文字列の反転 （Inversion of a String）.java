import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int length = Integer.parseInt(st.nextToken());
        int index1 = Integer.parseInt(st.nextToken()) - 1;
        int index2 = Integer.parseInt(st.nextToken()) - 1;

        String sentence = br.readLine();
        int count = index2;

        char[] chars = sentence.toCharArray();

        for(int i = 0;i < length;i++){
            if(i >= index1 && i <= index2){
                sb.append(chars[count]);
                count--;
            }else{
                sb.append(chars[i]);
            }
        }

        System.out.print(sb);
    }
}
