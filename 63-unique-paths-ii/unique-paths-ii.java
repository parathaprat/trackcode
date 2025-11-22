class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        if(obstacleGrid[0][0] == 1) return 0;

        //number of ways to reach i, j
        dp[0][0] = 1;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if(i == 0 && j == 0) continue;

                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else{

                    int fromTop = i > 0 ? dp[i - 1][j] : 0;
                    int fromLeft = j > 0 ? dp[i][j - 1] : 0;

                    dp[i][j] = fromTop + fromLeft;
                }
            }
        }

        return dp[rows - 1][cols - 1];


        
    }
}