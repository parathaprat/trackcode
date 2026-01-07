class Solution {
    public int jump(int[] nums) {

        int near = 0;
        int far = 0;
        int jumps = 0;

        while(far < nums.length - 1){

            int farthest = 0;

            for(int i = near; i <= far; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }

            near = far + 1;
            far = farthest;
            jumps++;
        }

        return jumps;
    }
}