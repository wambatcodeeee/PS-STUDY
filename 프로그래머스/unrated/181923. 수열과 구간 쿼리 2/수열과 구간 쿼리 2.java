class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int num = 1000000;
        
        for(int i = 0;i < queries.length;i++){
            num = 1000000;
            for(int j = queries[i][0];j <= queries[i][1];j++){
                if(queries[i][2] < arr[j]){
                    num = Math.min(num, arr[j]);
                }
            }
            answer[i] = num == 1000000 ? -1 : num;
        }
        return answer;
    }
}