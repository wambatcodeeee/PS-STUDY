import java.util.*;

class Solution {
    static int[][] people = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    public int[] solution(int[] answers) {
        int[] rank = new int[3];
        for(int i = 0;i < answers.length;i++){
            if(answers[i] == people[0][i % people[0].length]) rank[0]++;
            if(answers[i] == people[1][i % people[1].length]) rank[1]++;
            if(answers[i] == people[2][i % people[2].length]) rank[2]++;
        }
        
        int max = -1;
        for(int i : rank) max = Math.max(max, i);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < 3;i++) if(rank[i] == max) list.add(i + 1);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}