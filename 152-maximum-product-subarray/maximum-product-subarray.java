class Solution {
    public int maxProduct(int[] nums) {

        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){

            if(nums[i] < 0){
                int temp = min;
                min = max;
                max = temp;
            }

            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max * nums[i], nums[i]);

            ans = Math.max(ans, max);
        }

        return ans;
        
    }
}