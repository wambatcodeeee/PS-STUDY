class Solution {
    public int solution(int[] num_list) {
        String odd = "";
        String even = "";
        
        for(int i:num_list){
            odd += i % 2 != 0 ? i : "";
            even += i % 2 == 0 ? i : "";
        }
    
        return Integer.parseInt(odd) + Integer.parseInt(even);
    }
}