import java.util.*;

class Group implements Comparable<Group> {
    int diamond;
    int iron;
    int stone;
    
    public Group(int diamond, int iron, int stone){
        this.diamond = diamond;
        this.iron = iron;
        this.stone = stone;
    }
    
    public int compareTo(Group o){
        if(this.diamond != o.diamond) return o.diamond - this.diamond;
        else if(this.iron != o.iron) return o.iron - this.iron;
        return o.stone - this.stone;
    }
}

class Solution {
    static PriorityQueue<Group> pq;
    public int solution(int[] picks, String[] minerals) {
        pq = new PriorityQueue<>();
        int answer = 0;
        int pick = picks[0] + picks[1] + picks[2];
        int max = pick * 5;
        int limit = Math.min(max, minerals.length);
        for(int i = 0;i < limit;i+=5){
            int size = Math.min(5, minerals.length - i);
            int dia = 0, iron = 0, stone = 0;
            
            for(int j = 0;j < size;j++){
                if(minerals[i + j].equals("diamond")) dia++;
                else if(minerals[i + j].equals("iron")) iron++;
                else stone++;
            }
            pq.add(new Group(dia, iron, stone));
        }
        
        while(!pq.isEmpty() && pick-- > 0){
            Group group = pq.poll();
            int dia = group.diamond, iron = group.iron, stone = group.stone;
            if(picks[0] != 0){
                answer += dia + iron + stone;
                picks[0]--;
            }
            else if(picks[1] != 0){
                answer += dia * 5 + iron + stone;
                picks[1]--;
            }
            else{
                answer += dia * 25 + iron * 5 + stone;
                picks[2]--;
            }
        }
        
        return answer;
    }
}