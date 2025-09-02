import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static int find(int[] array, long mid){
        int count = 0;

        for(int i : array){
            count += (int) (i / mid);
        }

        return count;
    }


    public static void solution(int[] array, int target) throws IOException {
        Arrays.sort(array);
        long result = 0;
        long lt = 1, rt = array[array.length - 1];
        long mid;

        while(lt <= rt){
            mid = (lt + rt) / 2;
            if(find(array, mid) >= target) {
                result = mid;
                lt = mid + 1;
            }
            else rt = mid - 1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] array = new int[num];

        for(int i = 0;i < num;i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        solution(array, target);

        bw.close();
        br.close();
    }
}