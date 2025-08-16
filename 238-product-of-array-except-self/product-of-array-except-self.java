class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //calculate prefix left and prefix right
        //multiply them tog

        //to avoid space complexity, prefixLeft in one pass from the left, prefixRight in another pass from the right

        int[] ans = new int[nums.length];

        ans[0] = 1;

        //first pass
        for(int i = 1; i < nums.length; i++){

            ans[i] = nums[i - 1] * ans[i - 1];

        }

        int post = 1;
        //2nd pass
        for(int i = nums.length - 1; i >= 0; i--){

            ans[i] = ans[i] * post;
            post *= nums[i];

        }

        return ans;
    }
}