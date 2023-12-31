class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        char[] chrArray = code.toCharArray();
        
        for(int i = 0;i < chrArray.length;i++){
            if(chrArray[i] == '1'){
                mode = mode == 0 ? 1 : 0;
                continue;
            }
            
            if(mode == 0 && i % 2 == 0){
                answer += Character.toString(chrArray[i]);
                continue;
            }else if(mode == 1 && i % 2 != 0){
                answer += Character.toString(chrArray[i]);
                continue;
            }
        }
        
        return answer == "" ? "EMPTY" : answer;
    }
}