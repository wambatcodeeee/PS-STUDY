class Solution {
    static String[] keys;
    static String[] tar;
    static int pressNum(char c){
        int press = Integer.MAX_VALUE;
        for(int i = 0;i < keys.length;i++){
            for(int j = 0;j < keys[i].length();j++){
                if(keys[i].charAt(j) == c) press = Math.min(press, j + 1);
            }
        }
        return press == Integer.MAX_VALUE ? -1 : press;
    }
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        keys = keymap;
        tar = targets;
        int idx = 0;
        for(int i = 0;i < targets.length;i++){
            int totalPress = 0;
            boolean flag = true;
            for(int j = 0;j < targets[i].length();j++){
                int press = pressNum(targets[i].charAt(j));
                if(press == -1){
                    flag = false;
                    break;
                }
                totalPress += press;
            }
            answer[i] = flag ? totalPress : -1;
        }
        
        
        return answer;
    }
}