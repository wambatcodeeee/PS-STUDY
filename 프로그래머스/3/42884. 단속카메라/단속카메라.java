import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int answer = 0;
        int recent = Integer.MIN_VALUE;
        
        for(int[] route : routes){
            if(recent < route[0]){
                recent = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}