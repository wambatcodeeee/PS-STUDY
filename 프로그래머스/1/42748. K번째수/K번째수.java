import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < commands.length;i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int idx = commands[i][2];
            int[] small = new int[end - start + 1];
            for(int j = 0;j < small.length;j++) small[j] = array[start - 1 + j];
            Arrays.sort(small);
            list.add(small[idx - 1]);
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}