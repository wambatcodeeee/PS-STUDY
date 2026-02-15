import java.util.*;

class Solution {
    static StringTokenizer st;
    void removeNum(PriorityQueue<Integer> pq, HashMap<Integer, Integer> map){
        while(!pq.isEmpty()){
            int current = pq.poll();
            if(map.containsKey(current)){
                map.put(current, map.get(current) - 1);
                if(map.get(current) == 0) map.remove(current);
                break;
            }
        }
    }
    
    int checkNum(PriorityQueue<Integer> pq, HashMap<Integer, Integer> map){
        while(!pq.isEmpty()){
            int current = pq.poll();
            if(map.containsKey(current)) return current;
        }
        return 0;
    }
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0;i < operations.length;i++){
            st = new StringTokenizer(operations[i]);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(op.equals("I")){
                pq1.add(num);
                pq2.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            else{
                if(map.isEmpty()) continue;
                if(num == -1) removeNum(pq1, map);
                else removeNum(pq2, map);
            }
        }
        
        if(map.isEmpty()) return new int[]{0, 0};
        int min = checkNum(pq1, map);
        int max = checkNum(pq2, map);
        
        return new int[]{max, min};
    }
}