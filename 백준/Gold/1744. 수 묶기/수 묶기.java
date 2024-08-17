import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> positiveNum = new ArrayList<>();
        ArrayList<Integer> negativeNum = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int one = 0;
        int zero = 0;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            switch(Integer.signum(num)) {
                case 1:
                    if(num > 1) positiveNum.add(num);
                    else one++;
                    break;

                case 0:
                    zero++;
                    break;

                case -1:
                    negativeNum.add(num);
                    break;
            }
        }

        Collections.sort(positiveNum, Collections.reverseOrder());
        Collections.sort(negativeNum);

        int result = 0;

        for(int i = 0; i < positiveNum.size(); i += 2){
            if(i + 1 < positiveNum.size()) result += positiveNum.get(i) * positiveNum.get(i + 1);
            else result += positiveNum.get(i);
        }

        for(int i = 0; i < negativeNum.size(); i += 2){
            if(i + 1 < negativeNum.size()) result += negativeNum.get(i) * negativeNum.get(i + 1);
            else if(zero == 0) result += negativeNum.get(i);
        }

        result += one;

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
