class Solution {
    public boolean canJump(int[] nums) {
        
        boolean[] dp = new boolean[nums.length];

        dp[nums.length - 1] = true;

        int toReach = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){

            if(nums[i] + i >= toReach){
                dp[i] = true;
                toReach = i;
            }
            else if(nums[i] + i < nums.length){
                dp[i] = false;
            }

        }

        return dp[0];
    }
}