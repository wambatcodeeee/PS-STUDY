import java.util.*;

class Solution {
    static int find(int v){
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }
    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb) parent[fb] = fa;
    }
    
    static int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0;i < n;i++) parent[i] = i;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(computers[i][j] == 1) union(i, j);
            }
        }
        
        for(int i = 0;i < parent.length;i++) parent[i] = find(i);
        HashSet<Integer> set = new HashSet<>();
        for(int i : parent) set.add(i);
        
        return set.size();
    }
}