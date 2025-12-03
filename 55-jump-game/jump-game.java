class Solution {
    public boolean canJump(int[] nums) {

        int toReach = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] + i >= toReach){
                toReach = i;
            }
        }

        return toReach == 0;
        
    }
}