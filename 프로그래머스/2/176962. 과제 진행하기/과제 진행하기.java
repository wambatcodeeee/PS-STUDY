import java.util.*;

class Homework{
    String name;
    int time;
    int need;
    
    public Homework(String name, int time, int need){
        this.name = name;
        this.time = time;
        this.need = need;
    }
}

class Solution {
    static int change(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        return hour * 60 + minute;
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Homework> pq1 = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
        Stack<Homework> stack = new Stack<>();
        for(int i = 0;i < plans.length;i++){
            String name = plans[i][0];
            int time = change(plans[i][1]);
            int need = Integer.parseInt(plans[i][2]);
            pq1.add(new Homework(name, time, need));
        }
        
        Homework current = pq1.poll();
        int idx = 0;
        
        while(!pq1.isEmpty()){
            Homework next = pq1.peek();
            int gap = next.time - current.time;
            
            if(current.need <= gap){
                answer[idx++] = current.name;
                int remain = gap - current.need;
                
                while(remain > 0 && !stack.isEmpty()){
                    Homework previous = stack.pop();
                    if(previous.need <= remain){
                        remain -= previous.need;
                        answer[idx++] = previous.name;
                    }
                    else{
                        previous.need -= remain;
                        stack.push(previous);
                        remain = 0;
                    }
                }
                
                current = pq1.poll();
            }
            else{
                current.need -= gap;
                stack.push(current);
                current = pq1.poll();
            }
        }
        
        answer[idx++] = current.name;
        while(!stack.isEmpty()) answer[idx++] = stack.pop().name;
        
        return answer;
    }
}