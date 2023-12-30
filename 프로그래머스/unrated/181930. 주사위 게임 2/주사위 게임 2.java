class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        int case1 = a + b + c;
        int case2 = (int)Math.pow(a, 2) + (int)Math.pow(b, 2) + (int)Math.pow(c, 2);
        int case3 = (int)Math.pow(a, 3) + (int)Math.pow(b, 3) + (int)Math.pow(c, 3);
        
        if(a != b && b != c && c != a){
            answer = case1;
        }else if(a == b && b == c && c == a){
            answer = case1 * case2 * case3;
        }else{
            answer = case1 * case2;
        }
        return answer;
    }
}