import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> flowers = new ArrayList<>();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            int startDate = startMonth * 100 + startDay;
            int endDate = endMonth * 100 + endDay;
            flowers.add(new int[]{startDate, endDate});
        }

        flowers.sort((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int result = 0;
        int last = 301;
        int target = 301;
        int index = 0;

        while(last <= 1130){
            boolean flag = false;
            while(index < num && flowers.get(index)[0] <= last){
                if(flowers.get(index)[1] > target){
                    target = flowers.get(index)[1];
                    flag = true;
                }
                index++;
            }

            if(!flag){
                System.out.println(0);
                return;
            }

            result++;
            last = target;
        }

        System.out.println(result);
    }
}
