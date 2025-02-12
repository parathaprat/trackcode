class Solution {
    public int maxSubArray(int[] nums) {
        
        //even if there is huge number on the left, it cant be picked it it gets -gated
        //so update sum = 0, each time the linear sum <= 0
        //also track maxSum, at each iteration, since sum can be smaller in the +ve range


        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];

            maxSum = Math.max(sum, maxSum);

            if(sum <= 0) sum = 0;

        }

        return maxSum;
    }
}