class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        switch(eq){
            case "=":
                if(ineq.equals(">")){
                    answer = n >= m ? 1 : 0;
                    break;
                }else if(ineq.equals("<")){
                    answer = n <= m ? 1 : 0;
                    break;
                }
            case "!":
                if(ineq.equals(">")){
                    answer = n > m ? 1 : 0;
                    break;
                }else if(ineq.equals("<")){
                    answer = n < m ? 1 : 0;
                    break;
                }
        }
        
        return answer;
    }
}