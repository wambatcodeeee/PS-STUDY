import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int count = 0;
        for(int i : reserve) set1.add(i);
        for(int i : lost){
            if(set1.contains(i)) set1.remove(i);
            else set2.add(i);
        }
        
        for(int i : set2){
            if(set1.contains(i - 1)){
                set1.remove(i - 1);
                count++;
            }
            else if(set1.contains(i + 1)){
                set1.remove(i + 1);
                count++;
            }
        }
        
        return n - (set2.size() - count);
    }
}