class Solution {
    public int lengthOfLIS(int[] nums) {

        //define dp array, shift prev by 1, since it starts at -1
        int[][] dp = new int[nums.length][nums.length + 1];

        for(int[] row : dp) Arrays.fill(row, -1);
        
        //take and not take logic
        return dfs(nums, 0, -1, dp);

    }

    public int dfs(int[] nums, int cur, int prev, int[][] dp){

        //base case
        if(cur == nums.length) return 0;

        //return dp[x][x + 1] if exists
        if(dp[cur][prev + 1] != -1) return dp[cur][prev + 1];

        //not include
        int LIS = dfs(nums, cur + 1, prev, dp);

        //include -> len increases
        if(prev == -1 || nums[cur] > nums[prev]){
            LIS = Math.max(LIS, 1 + dfs(nums, cur + 1, cur, dp));
        }

        //memoize and return final ans
        return dp[cur][prev + 1] = LIS;


    }
}