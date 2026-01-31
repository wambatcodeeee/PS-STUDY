import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] array;
    static int start = 0, end = 0;

    public static int solution(int mid){
        int count = 1, sum = 0;
        for(int i = 0;i < N;i++){
            if(sum + array[i] > mid){
                count++;
                sum = 0;
            }
            sum += array[i];
        }

        return count;
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int result = Integer.MAX_VALUE;
        array = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < N;i++) {
            array[i] = Integer.parseInt(st.nextToken());
            end += array[i];
            start = Math.max(start, array[i]);
        }
        
        while(start <= end){
            int mid = (start + end) / 2;
            int count = solution(mid);
            if(count <= M) {
                result = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}