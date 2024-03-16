import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Main {
    static int result1(int[] array, int num){
        double result1 = 0;

        for(int i:array){
            result1 += i;
        }
        return (int)Math.round(result1 / num);
    }

    static int result2(int[] array, int num){
        return array[num / 2];
    }

    static int result3(int[] array){
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        int max = 0;

        for(int i:array){
            hashMap.put(i, 0);
        }

        for(int i:array){
            if(hashMap.containsKey(i)){
                hashMap.put(i, hashMap.get(i) + 1);
            }
        }

        ArrayList<Integer> keyArray = new ArrayList<>(hashMap.keySet());

        for(int i:keyArray){
            int num = hashMap.get(i);
            max = Math.max(max, num);
        }

        ArrayList<Integer> resultArray = new ArrayList<>();

        for(int i:keyArray){
            if(hashMap.get(i) == max){
                resultArray.add(i);
            }
        }

        Collections.sort(resultArray);

        return resultArray.size() == 1 ? resultArray.get(0) : resultArray.get(1);
    }

    static int result4(int[] array, int num){
        return array[num-1] - array[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num];

        for(int i = 0;i < num;i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        bw.write(result1(array, num) + "\n");
        bw.write(result2(array, num) + "\n");
        bw.write(result3(array) + "\n");
        bw.write(result4(array, num) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
