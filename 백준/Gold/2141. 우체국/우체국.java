import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        ArrayList<int[]> villages = new ArrayList<>();

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int population = Integer.parseInt(st.nextToken());
            villages.add(new int[]{position, population});
        }

        villages.sort(Comparator.comparingInt(a -> a[0]));

        long total = 0;

        for(int[] village : villages){
            total += village[1];
        }

        long plus = 0;
        int result = 0;

        for(int[] village : villages){
            plus += village[1];
            if(plus * 2 >= total){
                result = village[0];
                break;
            }
        }

        System.out.println(result);
    }
}
