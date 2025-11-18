class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[] dp = new int[cols];

        dp[0] = 1;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }
                else{
                    if(j > 0){
                        dp[j] += dp[j - 1];
                    }
                }
            }
        }

        return dp[cols - 1];
        
    }
}