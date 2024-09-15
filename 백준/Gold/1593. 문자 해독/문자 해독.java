import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lengthW = Integer.parseInt(st.nextToken());
        int lengthS = Integer.parseInt(st.nextToken());
        String W = br.readLine();
        String S = br.readLine();

        if(lengthW > lengthS) return;

        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for(char c : W.toCharArray()){
            hashMap1.put(c, hashMap1.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int result = 0;

        while(end < lengthS){
            char c = S.charAt(end);
            hashMap2.put(c, hashMap2.getOrDefault(c, 0) + 1);

            if(lengthW == end - start + 1){
                if(hashMap2.equals(hashMap1)) result++;
                char startChar = S.charAt(start);
                hashMap2.put(startChar, hashMap2.get(startChar) - 1);

                if(hashMap2.get(startChar) == 0) hashMap2.remove(startChar);
                start++;
            }
            end++;
        }
        System.out.println(result);
    }
}
