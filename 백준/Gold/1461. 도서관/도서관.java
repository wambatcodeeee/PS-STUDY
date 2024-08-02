import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int books = Integer.parseInt(st.nextToken());
        int carry = Integer.parseInt(st.nextToken());

        int[] positions = new int[books];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < books; i++){
            positions[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> positiveNum = new ArrayList<>();
        ArrayList<Integer> negativeNum = new ArrayList<>();

        for(int pos : positions){
            if(pos < 0) positiveNum.add(-pos);
            else negativeNum.add(pos);
        }

        Collections.sort(positiveNum, Collections.reverseOrder());
        Collections.sort(negativeNum, Collections.reverseOrder());

        int result = 0;

        for(int i = 0; i < positiveNum.size(); i += carry){
            result += positiveNum.get(i) * 2;
        }

        for(int i = 0; i < negativeNum.size(); i += carry){
            result += negativeNum.get(i) * 2;
        }

        if(!positiveNum.isEmpty() && !negativeNum.isEmpty()) result -= Math.max(positiveNum.get(0), negativeNum.get(0));
        else if(!positiveNum.isEmpty()) result -= positiveNum.get(0);
        else if(!negativeNum.isEmpty()) result -= negativeNum.get(0);

        System.out.println(result);
    }
}
