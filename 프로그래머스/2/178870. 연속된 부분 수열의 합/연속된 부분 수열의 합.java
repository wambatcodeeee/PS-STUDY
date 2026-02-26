class Solution {
    public int[] solution(int[] sequence, int k) {
        long sum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1, endIdx = -1;
        
        for(int right = 0;right < sequence.length;right++){
            sum += sequence[right];
            
            while(sum > k) sum -= sequence[left++];
            if(sum == k){
                int length = right - left + 1;
                if(length < minLen){
                    startIdx = left;
                    endIdx = right;
                    minLen = length;
                }
            }
        }
        
        int[] answer = {startIdx, endIdx};
        return answer;
    }
}