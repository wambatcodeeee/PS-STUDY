import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++) array[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(array);

        for(int i = 0;i < N;i++){
            int left = 0;
            int right = N - 1;

            while(left < right){
                int currentSum = array[left] + array[right];
                if(currentSum > array[i]) right--;
                else if(currentSum < array[i]) left++;
                else{
                    if(left == i) left++;
                    else if(right == i) right--;
                    else{
                        result++;
                        break;
                    }
                }
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}