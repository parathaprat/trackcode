class Solution {
    public int climbStairs(int n) {
        
        //step 0 and step 1 has only 1 way to get to them

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
        
    }
}