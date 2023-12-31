class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int num = a;
        
        for(boolean b:included){
            if(b == true){
                answer += num;
            }
            num = num + d;  
        }
        
        return answer;
    }
}