class Solution {
    public int maxSubArray(int[] nums) {

        if(nums.length == 1) return nums[0];
        
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int r = 0; r < nums.length; r++){

            sum += nums[r];

            maxSum = Math.max(sum, maxSum);

            if(sum <= 0){
                sum = 0;
            }

        }

        return maxSum;
    }
}