class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //use prefix sums for left, right and ans array

        int N = nums.length;  
        int[] leftProduct = new int[N];
        int[] rightProduct = new int[N];
        int[] ans = new int[N];

        //start of left and end of right = 1;
        leftProduct[0] = 1;
        rightProduct[N - 1] = 1;

        //initialize left and right products
        for(int i = 1; i < N; i++){
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        for(int i = N - 2; i >= 0; i--){
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        //ans = left * right
        for(int i = 0; i < N; i++){
            ans[i] = leftProduct[i] * rightProduct[i];
        }

        return ans;
    }
}