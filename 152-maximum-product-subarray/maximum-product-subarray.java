class Solution {
    public int maxProduct(int[] nums) {

        //keep track of max and min products at each index
        //swap when element is -ve

        int min = nums[0];
        int max = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){

            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            res = Math.max(max, res);
        }

        return res;
    }
}