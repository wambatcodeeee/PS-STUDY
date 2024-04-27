import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        ArrayList<Character> arrayList = new ArrayList<>();
        for(int i = 0; i < num; i++){
            arrayList.add(br.readLine().charAt(0));
        }
        
        int left = 0;
        int right = num - 1;

        while(left <= right){
            boolean leftSmaller = false;

            for(int i = 0; left + i <= right; i++){
                if(arrayList.get(left + i) < arrayList.get(right - i)){
                    leftSmaller = true;
                    break;
                }else if(arrayList.get(left + i) > arrayList.get(right - i)){
                    break;
                }
            }

            if(leftSmaller){
                sb.append(arrayList.get(left++));
            }else{
                sb.append(arrayList.get(right--));
            }

            if(sb.length() % 80 == 0){
                bw.write(sb.toString() + "\n");
                sb.setLength(0);
            }
        }

        if(sb.length() > 0){
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
