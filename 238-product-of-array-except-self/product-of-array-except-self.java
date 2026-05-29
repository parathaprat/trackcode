class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //left side products in ans
        //runnning right product in a variable

        int[] ans = new int[nums.length];

        ans[0] = 1;

        //prefix products
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int post = 1;

        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] = ans[i] * post;
            post = post * nums[i];
        }

        return ans; 
    }
}