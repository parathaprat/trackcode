class Solution {
    public int maxProduct(int[] nums) {
        
        //product -> can switch max to min with one -ve sign// min only maintained because of this

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){

            //if -ve encountered, switch max and min
            if(nums[i] < 0){
                
                int temp = max;
                max = min;
                min = temp;

            }

            //update max and min between product with next num or jsut next num
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            //update result at each iteration
            result = Math.max(result, max);

        }

        return result;
    }
}