class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length + 1]; //LIS from index i to the end

        Arrays.fill(dp, 1); //LIS at each index is atleast 1;

        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){

                if(nums[j] > nums[i]) dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }

        int ans = 0;

        for(int num : dp){
            ans = Math.max(ans, num);
        }

        return ans;
    }
}