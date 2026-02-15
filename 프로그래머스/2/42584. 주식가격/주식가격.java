import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i : prices) queue.add(i);
        
        int idx = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            for(int i : queue){
                answer[idx]++;
                if(current > i) break;
            }
            
            idx++;
        }
        
        return answer;
    }
}