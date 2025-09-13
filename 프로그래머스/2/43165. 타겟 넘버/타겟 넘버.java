import java.util.*;

class Solution {
    public static class Node{
    int index;
    int data;
    
    public Node(int index, int data){
        this.data = data;
        this.index = index;
    }
}
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, 0));
        
        while(!stack.isEmpty()){
            Node current = stack.pop();
            
            if(current.index == numbers.length){
                if(current.data == target){
                    answer++;
                }
                continue;
            }
            
            stack.push(new Node(current.index + 1, current.data + numbers[current.index]));
            stack.push(new Node(current.index + 1, current.data - numbers[current.index]));   
        }
        
        return answer;
    }
}