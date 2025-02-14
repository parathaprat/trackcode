class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prefixLeft = new int[nums.length];
        int[] prefixRight = new int[nums.length];

        prefixLeft[0] = 1;

        prefixRight[nums.length - 1] = 1; 

        //populating prefixLeft
        for(int i = 1; i < nums.length; i++){

            prefixLeft[i] = prefixLeft[i - 1] * nums[i - 1];

        }

        //populating prefixRight
        for(int i = nums.length - 2; i >= 0; i--){

            prefixRight[i] = prefixRight[i + 1] * nums[i + 1];

        }

        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){

            ans[i] = prefixLeft[i] * prefixRight[i];

        }

        return ans;

    }
}