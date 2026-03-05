import java.util.*;

class Solution {
    static int check(int mid, int[] rocks, int distance){
        int recent = 0;
        int count = 0;
        
        for(int i = 0;i < rocks.length;i++){
            if(rocks[i] - recent < mid){
                count++;
                continue;
            }
            recent = rocks[i];
        }
        
        if(distance - recent < mid) count++;
        return count;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = 0, right = distance;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(check(mid, rocks, distance) <= n) {
                left = mid + 1;
                answer = mid;
            }
            else right = mid - 1;
        }
        
        return answer;
    }
}