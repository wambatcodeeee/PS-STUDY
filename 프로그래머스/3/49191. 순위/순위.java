class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] dp = new int[n + 1][n + 1];
        for(int[] array : results){
            dp[array[0]][array[1]] = 1;
            dp[array[1]][array[0]] = -1;
        }
        
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= n;j++){
                for(int k = 1;k <= n;k++){
                    if(dp[i][k] == 1 && dp[k][j] == 1){
                        dp[i][j] = 1;
                        dp[j][i] = -1;
                    }
                    
                    if(dp[i][k] == -1 && dp[k][j] == -1){
                        dp[i][j] = -1;
                        dp[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 0;i <= n;i++){
            int count = 0;
            for(int j = 0;j <= n;j++) if(dp[i][j] != 0) count++;
            if(count == n - 1) answer++;
        }
        
        return answer;
    }
}