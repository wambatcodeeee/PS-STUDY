import java.util.*;

class Process implements Comparable<Process>{
    int start;
    int time;
    
    public Process(int start, int time){
        this.start = start;
        this.time = time;
    }
    
    public int compareTo(Process o){
        return this.time - o.time;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Process> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int answer = 0;
        int idx = 0;
        int currentTime = 0;
        
        while(!pq.isEmpty() || idx < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= currentTime) {
                pq.add(new Process(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(pq.isEmpty()) currentTime = jobs[idx][0];
            else {
                Process currentP = pq.poll();
                currentTime += currentP.time;
                answer += currentTime - currentP.start;
            }
        }
        
        return answer / jobs.length;
    }
}