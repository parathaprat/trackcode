class Solution {
    public int waysToSplitArray(int[] nums) {
        
        long totalSum = 0;
        long leftSum = 0;
        int ans = 0;

        //calcuclate total sum
        for(int i = 0; i < nums.length; i++){

            totalSum += nums[i];

        }

        //go through array again, get sum of left and right elements, compare at each point and ++ ans
        for(int i = 0; i < nums.length - 1; i++){

            leftSum += nums[i];

            long rightSum = totalSum - leftSum;

            if(leftSum >= rightSum){
                ans++;
            }

        }

        return ans;

    }
}