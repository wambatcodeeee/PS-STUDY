import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            int num = Integer.parseInt(br.readLine());
            int[] numArray = new int[num];
            st = new StringTokenizer(br.readLine());

            for(int n = 0; n < num; n++){
                numArray[n] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numArray);

            int[] array = new int[num];
            int left = 0;
            int right = num - 1;

            for(int n = 0; n < num; n++){
                if(n % 2 == 0) array[left++] = numArray[n];
                else array[right--] = numArray[n];
            }

            int result = 0;

            for(int n = 1; n < num; n++){
                result = Math.max(result, Math.abs(array[n] - array[n - 1]));
            }

            result = Math.max(result, Math.abs(array[num - 1] - array[0]));
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
