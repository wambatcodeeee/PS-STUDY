import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = br.readLine();
        char[] charArr = sentence.toUpperCase().toCharArray();
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        int max = 0;

        for(char i:charArr){
            hashMap.put(i, 0);
        }

        for(char i:charArr){
            if(hashMap.containsKey(i)){
                hashMap.put(i, hashMap.get(i) + 1);
            }
        }

        ArrayList<Character> keyArray = new ArrayList<>(hashMap.keySet());

        for(char i:keyArray){
            int num = hashMap.get(i);
            max = Math.max(max, num);
        }

        ArrayList<Character> resultArray = new ArrayList<>();

        for(char i:keyArray){
            if(hashMap.get(i) == max){
                resultArray.add(i);
            }
        }

        Collections.sort(resultArray);

        bw.write(resultArray.size() == 1 ? String.valueOf(resultArray.get(0)) : "?");
        bw.flush();
        bw.close();
        br.close();
    }
}
