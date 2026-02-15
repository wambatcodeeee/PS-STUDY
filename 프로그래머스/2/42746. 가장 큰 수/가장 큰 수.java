import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] array = new String[numbers.length];
        for(int i = 0;i < numbers.length;i++) array[i] = String.valueOf(numbers[i]);
        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));
        for(String s : array) answer += s;
        if(answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}