import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;

        while(n > right){
            int difference = array[right] - array[left];
            if(m <= difference){
                min = Math.min(min, difference);
                left++;
                if(left > right) right = left;
            }else right++;
        }

        System.out.println(min);
    }
}
