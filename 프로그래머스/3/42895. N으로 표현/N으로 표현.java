import java.util.*;

class Solution {
    public int solution(int N, int number) {
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        
        for(int i = 0;i < 9;i++) list.add(new HashSet<>());
        for(int i = 1;i <= 8;i++) {
            list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for(int j = 1;j < i;j++){
                for(int first : list.get(j)){
                    for(int second : list.get(i - j)){
                        list.get(i).add(first + second);
                        list.get(i).add(first - second);
                        list.get(i).add(first * second);
                        if(second != 0) list.get(i).add(first / second);
                    }
                }
            }
            
            if(list.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}