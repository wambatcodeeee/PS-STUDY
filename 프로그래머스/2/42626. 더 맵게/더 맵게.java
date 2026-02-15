import java.util.*;

class Solution {
    public long solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1, o2));
        long answer = 0;
        for(long i : scoville) pq.add(i);
        
        while(pq.size() > 1 && pq.peek() < K){
            long first = pq.poll();
            long second = pq.poll();
            
            pq.add(first + (second * 2));
            answer++;
        }
        
        return pq.peek() < K ? -1 : answer;
    }
}