import java.util.*;

class Node implements Comparable<Node>{
    int start;
    int end;
    int cost;
    
    public Node(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

class Solution {
    static int[] parent;
    
    static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    
    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb) parent[fb] = fa;
    }
    
    public int solution(int n, int[][] costs) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int answer = 0;
        parent = new int[n + 1];
        for(int i = 1;i <= n;i++) parent[i] = i;
        for(int i = 0;i < costs.length;i++) pq.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
        
        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(find(current.start) != find(current.end)) {
                union(current.start, current.end);
                answer += current.cost;
            }
        }
        
        return answer;
    }
}