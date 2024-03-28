import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int result = 0;

        Integer[] list1 = new Integer[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < num;i++){
            list1[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] list2 = new Integer[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < num;i++){
            list2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list1);
        Arrays.sort(list2, Collections.reverseOrder());

        for(int i = 0;i < num;i++){
            result += list1[i] * list2[i];
        }

        System.out.print(result);
    }
}
