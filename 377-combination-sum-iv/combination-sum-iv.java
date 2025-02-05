class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target + 1];

        Arrays.fill(dp, -1);

        return getAns(target, dp, nums);
    }

    public int getAns(int i, int[] dp, int[] nums){

        //base case
        if(i == 0) return 1;

        if(dp[i] != -1) return dp[i];

        int ways = 0;

        for(int j = 0; j < nums.length; j++){

            if(i - nums[j] >= 0){

                ways += getAns(i - nums[j], dp, nums);

            }

        }

        return dp[i] = ways;

    }
}