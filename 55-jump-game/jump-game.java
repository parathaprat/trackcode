class Solution {
    public boolean canJump(int[] nums) {

        //toReach tracks the node from which teh end can be reached.
        //toReach is at the end, iterate from 2nd last and check if it can reach toReach
        //if it can, toReach = i
        //if itoReach == 0, true 

        int toReach = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] + i >= toReach){
                toReach = i;
            }
        }
        
        return toReach == 0;
    }
}