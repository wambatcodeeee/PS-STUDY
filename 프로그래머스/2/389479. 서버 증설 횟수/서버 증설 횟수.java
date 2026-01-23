import java.util.*;

class Server{
    int time;
    
    public Server(int time){
        this.time = time;
    }
}

class Solution {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<Server> pq = new PriorityQueue<>((o1, o2) -> (o1.time - o2.time));
        int answer = 0;
        
        for(int i = 0;i < players.length;i++){
            while(!pq.isEmpty() && pq.peek().time <= i) pq.poll();
            int n = players[i] / m;
            
            while(pq.size() < n){
                pq.add(new Server(i + k));
                answer++;
            }
        }
        
        return answer;
    }
}