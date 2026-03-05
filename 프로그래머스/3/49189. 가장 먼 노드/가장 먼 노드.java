import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int[] dist;
    
    static int BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        dist[1] = 0;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            for(int next : list.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }
        }
        
        int max = 0, count = 0;;
        for(int i = 1;i < dist.length;i++) max = Math.max(max, dist[i]);
        for(int i = 1;i < dist.length;i++) if(max == dist[i]) count++;
        return count;
    }
    
    public int solution(int n, int[][] edge) {
        list = new ArrayList<>();
        for(int i = 0;i <= n;i++) list.add(new ArrayList<>());
        for(int i = 0;i < edge.length;i++){
            int start = edge[i][0];
            int end = edge[i][1];
            list.get(start).add(end);
            list.get(end).add(start);
        }
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        return BFS();
    }
}