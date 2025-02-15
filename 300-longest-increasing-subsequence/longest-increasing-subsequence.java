class Solution {
    public int lengthOfLIS(int[] nums) {
        
        //start from the back of the array, last elements LIS == 1;
        //every element i before LIS = Math.max(LIS[j], 1 + LIS[j]) while nums[i] < nums[j]

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){

                if(nums[i] < nums[j]){
                
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    
                }

            }
        }
        
        int ans = 0;

        for(int max : dp){
            
            if(max > ans) ans = max;
        }

        return ans;
    }
}