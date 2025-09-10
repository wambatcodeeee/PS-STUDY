import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static int find(int[] array, int mid){
        int count = 1;
        int point = array[0];

        for(int i = 1;i < array.length;i++){
            if(mid <= array[i] - point) {
                count++;
                point = array[i];
            }
        }

        return count;
    }

    public static void solution(int[] array, int machine) throws IOException {
        Arrays.sort(array);
        int result = 0;
        int lp = 1, rp = array[array.length - 1];
        int mid;

        while(lp <= rp){
            mid = (lp + rp) / 2;
            if(find(array, mid) >= machine) {
                result = mid;
                lp = mid + 1;
            }
            else rp = mid - 1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int house = Integer.parseInt(st.nextToken());
        int machine = Integer.parseInt(st.nextToken());
        int[] array = new int[house];

        for(int i = 0;i < house;i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        solution(array, machine);

        bw.close();
        br.close();
    }
}