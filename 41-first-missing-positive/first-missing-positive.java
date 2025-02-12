class Solution {
    public int firstMissingPositive(int[] nums) {
        

        //we are dealing only with +ves                                   [0, 1, 2, 3, 4, 5..]
        //swap +ve number nums[i] = x to x - 1th position in the array -> [1, 2, 3, 4, 5, 6..];

        for(int i = 0; i < nums.length; i++){

            //if nums[i] is +ve and in range
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){

                int temp = nums[nums[i] - 1];

                nums[nums[i] - 1] = nums[i];

                nums[i] = temp;

                i--;
                
            }

        }

        for(int i = 0; i < nums.length; i++){

            if(nums[i] != i + 1) return i + 1;
        }

        return nums.length + 1;

    }
}