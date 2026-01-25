class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        int[] answer = new int[n];
        int divided = s / n;
        int remainder = s % n;
        
        for(int i = answer.length - 1;i >= 0;i--){
            answer[i] = divided;
            if(remainder > 0) {
                answer[i]++;
                remainder--;
            }
        }
        
        return answer;
    }
}