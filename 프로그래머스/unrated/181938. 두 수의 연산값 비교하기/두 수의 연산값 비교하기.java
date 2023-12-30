class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int num = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int pivot = 2 * a * b;
        
        answer = num > pivot ? num : pivot; 
        return answer;
    }
}