import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        for(int i : section) queue.add(i);
        int answer = 0;
        
        int idx = 1;
        while(!queue.isEmpty() && idx <= n){
            if(queue.peek() == idx){
                for(int i = idx;i < idx + m && i <= n;i++) {
                    visited[i] = true;
                    if(!queue.isEmpty() && queue.peek() == i) queue.poll();
                }
                answer++;
                idx += m;
            }
            else idx++;
        }
        
        return answer;
    }
}