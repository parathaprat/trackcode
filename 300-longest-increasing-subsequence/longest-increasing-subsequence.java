class Solution {
    public int lengthOfLIS(int[] nums) {
        
        //bottom up
        //LIS at last element = 1;
        //is cur < other elemetns after; dp[cur] = Math.max(dp[cur]. 1 + dp[other elements])

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for(int i = nums.length - 1; i >= 0; i--){

            for(int j = i + 1; j < nums.length; j++){

                if(nums[i] < nums[j]){

                    dp[i] = Math.max(dp[i], 1 + dp[j]);

                }
            }
        }

        //each dp shows LIS at each index, return max

        int ans = 0;

        for(int num : dp){
            
            if(num > ans) ans = num;
        }

        return ans;
    }
}