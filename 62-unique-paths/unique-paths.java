class Solution {
    public int uniquePaths(int m, int n) {

        int rows = m;
        int cols = n;

        int[][] dp = new int[rows][cols];

        dp[0][0] = 1;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if(i == 0 && j == 0) continue;

                int fromTop = i > 0 ? dp[i - 1][j] : 0;
                int fromLeft = j > 0 ? dp[i][j - 1] : 0;

                dp[i][j] = fromTop + fromLeft;
            }
        }

        return dp[rows - 1][cols - 1];
        
    }
}