import java.util.*;

class Solution {
    static String[] users;
    static String[] banUsers;
    static Set<Set<String>> set1;
    
    public static void DFS(Set<String> set2, int L){
        if(L == banUsers.length){
            set1.add(set2);
            return;
        }
        
        for(int i = 0;i < users.length;i++){
            if(set2.contains(users[i]) || users[i].length() != banUsers[L].length()) continue;
            if(checkId(users[i], banUsers[L])){
                set2.add(users[i]);
                DFS(new HashSet<>(set2), L + 1);
                set2.remove(users[i]);
            }
        }
    }
    
    public static boolean checkId(String uid, String bid){
        for(int i = 0;i < uid.length();i++){
            if(bid.charAt(i) != '*' && uid.charAt(i) != bid.charAt(i)) return false;
        }
        
        return true;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        banUsers = banned_id;
        set1 = new HashSet<>();
        DFS(new HashSet<>(), 0);
        
        return set1.size();
    }
}