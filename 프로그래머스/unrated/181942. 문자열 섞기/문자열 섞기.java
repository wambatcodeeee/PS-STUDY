class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        for(int i = 0;i<charArray1.length;i++){
            answer += Character.toString(charArray1[i]);
            answer += Character.toString(charArray2[i]);
        }
        return answer;
    }
}