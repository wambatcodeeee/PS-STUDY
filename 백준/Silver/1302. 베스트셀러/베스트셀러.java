import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();

        int num = Integer.parseInt(br.readLine());
        int max = 0;
        String result = "";

        for(int i = 0;i < num;i++){
            String name = br.readLine();
            if(!hashMap.containsKey(name)) hashMap.put(name, 1);
            else hashMap.put(name, hashMap.get(name) + 1);
        }

        ArrayList<String> keySet = new ArrayList<>(hashMap.keySet());

        for(String s:keySet){
            int check = hashMap.get(s);

            if(max < check){
                max = check;
                result = s;
            }else if(max == check){
                if(s.compareTo(result) < 0){
                    result = s;
                }
            }
        }

        System.out.print(result);
    }
}
