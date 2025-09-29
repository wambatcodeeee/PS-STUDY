import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String[] sentenceArray;
    static int result = 1;
    static boolean flag = false;
    static HashMap<String, Integer> hashMap = new HashMap<>();

    public static String newWordFunc(String str){
        if(str.length() <= 2) return str;
        else{
            char[] chars = str.substring(1, str.length() - 1).toCharArray();
            Arrays.sort(chars);
            return str.charAt(0) + new String(chars) + str.charAt(str.length() - 1);
        }
    }

    public static void solution() throws IOException {
        for(String s : sentenceArray){
            st = new StringTokenizer(s);
            while(st.hasMoreTokens()){
                String newWord = newWordFunc(st.nextToken());
                if(hashMap.containsKey(newWord)){
                    flag = true;
                    result *= hashMap.get(newWord);
                }
            }
            if(flag) bw.write(String.valueOf(result));
            else bw.write("0");
            bw.newLine();
            result = 1;
            flag = false;
        }
    }


    public static void main(String[] args) throws IOException {
        int dict = Integer.parseInt(br.readLine());
        for(int i = 0;i < dict;i++){
            String str = br.readLine();
            String newWord = newWordFunc(str);
            hashMap.put(newWord, hashMap.getOrDefault(newWord, 0) + 1);
        }

        int sentence = Integer.parseInt(br.readLine());
        sentenceArray = new String[sentence];
        for(int i = 0;i < sentence;i++){
            sentenceArray[i] = br.readLine();
        }

        solution();

        bw.flush();
        bw.close();
        br.close();
    }
}