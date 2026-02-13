import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int answer = 1;
        for(int i = 0;i < clothes.length;i++){
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0) + 1);   
        }
        
        for(int count : hashMap.values()){
            answer *= count + 1;
        }
        
        return answer - 1;
    }
}