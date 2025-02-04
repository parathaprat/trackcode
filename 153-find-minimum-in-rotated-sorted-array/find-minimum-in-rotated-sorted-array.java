class Solution {
    public int findMin(int[] nums) {
        
        //binary search the smallest element

        int left = 0; 
        int right = nums.length - 1;

        while(left < right){

            int mid = left + (right - left) / 2;

            if(nums[mid] >= nums[left] && nums[mid] > nums[right]){
                left = mid + 1;
            }
            else if(nums[mid] < nums[left] && nums[mid] < nums[right] && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            else{
                right = mid - 1;
            }


        }

        return nums[left];

        
    }
}