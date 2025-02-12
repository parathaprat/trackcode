class Solution {
    public int missingNumber(int[] nums) {
        
        //cyclic sort
        //nums[i] should be placed at i if possible

        for(int i = 0; i < nums.length; i++){

            //if num is not equal to its index and is in range, swap
            if(nums[i] != i && nums[i] < nums.length){

                int temp = nums[nums[i]];

                nums[nums[i]] = nums[i];

                nums[i] = temp;

                i--;
                
            }
        }

        for(int i = 0; i < nums.length; i++){

            if(nums[i] != i){
                return i;
            }
        }

        return nums.length;
    }
}