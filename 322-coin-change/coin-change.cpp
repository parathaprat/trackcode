class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        // dp[i][amt] = min coins to form amt using coins[i..]
        vector<vector<int>> dp(n, vector<int>(amount + 1, -1));
        
        int ans = dfs(coins, amount, 0, dp);
        return (ans >= 1e9 ? -1 : ans);
    }

    int dfs(vector<int>& coins, int amount, int i, vector<vector<int>>& dp) {
        if (amount == 0) return 0;                 // no coins needed
        if (i >= coins.size() || amount < 0) return 1e9; // impossible case

        if (dp[i][amount] != -1) return dp[i][amount];

        // take this coin (stay at same index because we can reuse unlimited times)
        int take = 1 + dfs(coins, amount - coins[i], i, dp);

        // skip this coin (move to next index)
        int skip = dfs(coins, amount, i + 1, dp);

        return dp[i][amount] = min(take, skip);
    }
};
