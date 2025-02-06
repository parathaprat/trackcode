class Solution {
    public int uniquePaths(int m, int n) {
        
        //bottom up dp appraoch
        //there is only 1 way to get from star to star -> 1
        //therefore only onw way to get to star from the last row and last col
        //populate last row and last col of dp array with 1s

        int[][] dp = new int[m][n];

        //dp[i] = ways to get from that place to star

        for(int i = 0; i < m; i++){
            dp[i][n - 1] = 1;
        }

        for(int i = 0; i < n; i ++){
            dp[m - 1][i] = 1;
        }

        //dp[i] = ways to star from down + ways to star from right
        
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){

                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];

            }
        }

        return dp[0][0];

    }
}