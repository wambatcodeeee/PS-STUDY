import java.util.*;

class Solution {
    static ArrayList<String> list;
    static char[] aeiou = {'A', 'E', 'I', 'O', 'U'};
    
    static void DFS(int L, String current){
        list.add(current);
        if(L == 5) return;
        for(int i = 0;i < 5;i++) DFS(L + 1, current + aeiou[i]);
    }
    
    public int solution(String word) {
        list = new ArrayList<>();
        int answer = 0;
        
        DFS(0, "");
        Collections.sort(list);
        for(int i = 0;i < list.size();i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
}