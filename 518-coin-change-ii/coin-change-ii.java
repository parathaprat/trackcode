class Solution {
    public int change(int amount, int[] coins) {

        // dp[x] = number of ways to form amount x using the coins seen so far.
        
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int coin : coins){
            for(int j = coin; j <= amount; j++){
                dp[j] += dp[j - coin];
            }
        }
        
        return dp[amount];
    }
}