class Solution {
    public int lengthOfLIS(int[] nums) {
        
        //brute force bottom up dp
        //LIS at last index => 1
        //dp[i] => LIS starting at index i

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        //go through entire array from the back
        for(int i = nums.length - 1; i >= 0; i--){

            //iterate from i to end and get LIS for that index
            for(int j = i + 1; j < nums.length; j++){

                if(nums[i] < nums[j]){

                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        //return max of dp array
        int ans = 0;
        for(int num : dp){
            
            if(num > ans) ans = num;
        }

        return ans;


    }
}