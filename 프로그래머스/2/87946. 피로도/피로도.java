import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    static int[][] array;
    
    static void DFS(int L, int health){
        for(int i = 0;i < array.length;i++){
            if(!visited[i] && array[i][0] <= health){
                visited[i] = true;
                DFS(L + 1, health - array[i][1]);
                visited[i] = false;
            }
        }
        
        answer = Math.max(L, answer);
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        array = dungeons;
        visited = new boolean[dungeons.length];
        DFS(0, k);
        return answer;
    }
}