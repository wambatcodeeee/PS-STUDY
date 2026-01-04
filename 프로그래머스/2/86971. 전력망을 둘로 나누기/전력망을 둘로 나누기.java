import java.util.*;

class Solution {
    static int[] parent;
    
    public static int find(int v){
        if(v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }
    
    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb) parent[fb] = fa;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0;i < wires.length;i++){
            parent = new int[n + 1];
            for(int o = 1;o <= n;o++) parent[o] = o;
            List<int[]> list = new ArrayList<>();
            
            for(int j = 0;j < wires.length;j++){
                if(i == j) continue;
                list.add(wires[j]);
            }
            
            for(int[] array : list) union(array[0], array[1]);
            
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int k = 1;k <= n;k++){
                hashMap.put(find(k), hashMap.getOrDefault(find(k), 0) + 1);
            }
            
            List<Integer> nums = new ArrayList<>();
            for(int m : hashMap.values()) nums.add(m);
            answer = Math.min(answer, Math.abs(nums.get(0) - nums.get(1)));
        }
        
        return answer;
    }
}