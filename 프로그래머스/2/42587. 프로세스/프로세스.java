import java.util.*;

class Solution {
    public static boolean checkMax(int process, Queue<Integer> queue){
        for(int i : queue){
            if(i > process) return false;
        }
        return true;
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        int result = 0;
        
        for(int i : priorities) queue1.add(i);
        for(int i = 0;i < priorities.length;i++) queue2.add(i);
        
        int count = 0;
        while(true){
            int process = queue1.poll();
            int idx = queue2.poll();
            
            if(checkMax(process, queue1)){
                count++;
                if(idx == location){
                    result = count;
                    break;
                }
            }else{
                queue1.add(process);
                queue2.add(idx);
            }
        }
        
        return result;
    }
}