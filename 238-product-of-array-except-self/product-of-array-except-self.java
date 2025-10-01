class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        ans[0] = 1;

        for(int i = 1; i < nums.length; i++){
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        int post = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] = ans[i] * post;
            post = post * nums[i];
        }

        return ans;
    }
}