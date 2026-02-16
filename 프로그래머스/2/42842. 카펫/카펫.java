class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int i = 1;i <= brown;i++){
            for(int j = 1;j <= brown;j++){
                if(brown + yellow == i * j){
                    if((i - 2) * (j - 2) == yellow) {
                        answer = new int[]{i, j};
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}