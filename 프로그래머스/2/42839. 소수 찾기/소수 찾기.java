import java.util.*;

class Solution {
    static int N;
    static String[] array;
    static boolean[] visited;
    static HashSet<Integer> set;
    
    boolean isPrime(int n){
        if(n < 2) return false;
        else{
            for(int i = 2; i * i <= n;i++){
                if(n % i == 0) return false;
            }
            return true;
        }
    }
    
    void DFS(String current){
        if(!current.equals("")){
            if(isPrime(Integer.parseInt(current))) {
                set.add(Integer.parseInt(current));
            }
        }
        
        for(int i = 0;i < N;i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(current + array[i]);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        N = numbers.length();
        array = new String[N];
        visited = new boolean[N];
        set = new HashSet<>();
        for(int i = 0;i < N;i++) array[i] = String.valueOf(numbers.charAt(i));
        DFS("");
        
        return set.size();
    }
}