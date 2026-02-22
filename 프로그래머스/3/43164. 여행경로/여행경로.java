import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> list;
    static int N;
    static String[][] ticketArray;
    
    static void DFS(int L, String start, String route){
        if(L == N) list.add(route);
        else{
            for(int i = 0;i < N;i++){
                if(!visited[i] && start.equals(ticketArray[i][0])){
                    visited[i] = true;
                    DFS(L + 1, ticketArray[i][1], route + " " + ticketArray[i][1]);
                    visited[i] = false;
                }
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        visited = new boolean[N];
        list = new ArrayList<>();
        ticketArray = tickets;
        
        DFS(0, "ICN", "ICN");
        Collections.sort(list);
        return list.get(0).split(" ");
    }
}