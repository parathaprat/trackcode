class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReach = 0;

        for(int i = 0; i < nums.length; i++){

            //if i ever exceeds maxReach, return false
            if(i > maxReach) return false;

            //if position + jump > maxReach, update maxReach
            if(nums[i] + i > maxReach) maxReach = nums[i] + i;

            if(maxReach >= nums.length - 1) return true;
        }

        return false;


    }
}