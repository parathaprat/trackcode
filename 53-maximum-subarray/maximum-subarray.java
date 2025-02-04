class Solution {
    public int maxSubArray(int[] nums) {
        
        //maintain max and sum variables
        int max = Integer.MIN_VALUE;

        int sum = 0;

        for(int i = 0 ; i < nums.length; i++){

            //add elements to sum and update max if greater
            sum += nums[i];

            if(sum > max) max = sum;

            //if sum ever goes <0, update to 0 [handles cases where -ve numbers start]
            if(sum < 0) sum = 0;

        }

        return max;
    }
}