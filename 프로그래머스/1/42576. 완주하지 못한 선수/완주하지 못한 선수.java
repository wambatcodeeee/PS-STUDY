import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap1 = new HashMap<>();
        String answer = "";
        
        for(String s : participant) hashMap1.put(s, hashMap1.getOrDefault(s, 0) + 1);
        for(String s: completion) hashMap1.put(s, hashMap1.get(s) - 1);
        
        for(String s: hashMap1.keySet()){
            if(hashMap1.get(s) != 0) answer = s;
        }
        
        return answer;
    }
}