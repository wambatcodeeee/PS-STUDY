class Solution {
    static int answer;
    static String tar;
    static String[] wordsArray;
    static boolean[] visited;
    static void DFS(String current, int idx, int L){
        if(checkStr(current, tar) == current.length()) answer = Math.min(answer, L);
        else{
            for(int i = 0;i < wordsArray.length;i++){
                if(!visited[i] && checkStr(current, wordsArray[i]) == current.length() - 1) {
                    visited[i] = true;
                    DFS(wordsArray[i], i, L + 1);
                    visited[i] = false;
                }
            }
        }
    }
    
    static int checkStr(String current, String target){
        int count = 0;
        for(int i = 0;i < current.length();i++){
            if(current.charAt(i) == target.charAt(i)) count++;
        }
        return count;
    }
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        tar = target;
        wordsArray = words;
        visited = new boolean[words.length];
        DFS(begin, 0, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}