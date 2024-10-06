import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0){
            String str = br.readLine();
            int integer = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<>();

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                hashMap.putIfAbsent(c, new ArrayList<>());
                hashMap.get(c).add(i);
            }

            for(HashMap.Entry<Character, ArrayList<Integer>> entry : hashMap.entrySet()){
                ArrayList<Integer> arrayList = entry.getValue();

                if(arrayList.size() < integer) continue;

                for(int i = 0; i <= arrayList.size() - integer; i++){
                    int start = arrayList.get(i);
                    int end = arrayList.get(i + integer - 1);
                    int length = end - start + 1;
                    min = Math.min(min, length);
                    
                    if(str.charAt(start) == str.charAt(end)) max = Math.max(max, length);
                }
            }

            if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) bw.write("-1" + "\n");
            else bw.write(min + " " + max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
