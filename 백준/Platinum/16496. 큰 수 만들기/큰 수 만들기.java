import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        String[] numbers = new String[num];

        for(int i = 0; i < num; i++){
            numbers[i] = st.nextToken();
        }

        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

        if(numbers[0].equals("0")) System.out.println("0");
        else{
            for(String numStr : numbers){
                sb.append(numStr);
            }

            System.out.println(sb);
        }
    }
}
