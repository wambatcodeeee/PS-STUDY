import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        int length = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        String table = br.readLine();

        for(int i = 0; i < length; i++) {
            if(table.charAt(i) == 'P') arrayList.add(i);
            else if(table.charAt(i) == 'H') arrayList1.add(i);
        }

        int result = 0;
        int current = 0;

        for(int person : arrayList) {
            while(current < arrayList1.size() && arrayList1.get(current) < person - distance) current++;
            if(current < arrayList1.size() && arrayList1.get(current) <= person + distance) {
                result++;
                current++;
            }
        }

        System.out.println(result);
    }
}
