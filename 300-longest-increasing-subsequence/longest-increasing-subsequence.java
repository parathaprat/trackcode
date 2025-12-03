class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length + 1];
        //dp[i] => LIS from that index to end
        //default one since each char alone can be a LIS
        Arrays.fill(dp, 1);

        int ans = 0;

        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){

                if(nums[j] > nums[i]){
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
        }

        for(int num : dp){
            ans = Math.max(ans, num);
        }

        return ans;


    }
}