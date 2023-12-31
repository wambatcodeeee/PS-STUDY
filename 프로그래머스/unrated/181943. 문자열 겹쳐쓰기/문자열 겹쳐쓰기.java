class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String updateStr = "";
        updateStr = my_string.substring(0, s) + overwrite_string;
        answer = updateStr + my_string.substring(updateStr.length());
        
        return answer;
    }
}