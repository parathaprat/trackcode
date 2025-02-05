class Solution {
    public int rob(int[] nums) {
        
        //edge cases
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        //dp1 skips last house (nums.len - 1 since we skip last house)
        int[] dp1 = new int[nums.length - 1];

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length - 1; i++){
            
            //curr + i - 2// i -1
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
        }


        //dp2 skips 1st house
        int[] dp2 = new int[nums.length];

        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for(int i = 3; i < nums.length; i++){

            //curr + i - 2, i - 1
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);

        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);




    }
}