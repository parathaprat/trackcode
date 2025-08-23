class Solution {
    public int findMin(int[] nums) {
        
        int l = 0;
        int r = nums.length - 1;

        while(l < r){

            int m = l + (r - l)/2;

            if(nums[m] >= nums[l] && nums[m] > nums[r]){
                l = m + 1;
            }
            else if(nums[m] < nums[l] && nums[m] < nums[r] && nums[m] < nums[m - 1]){
                return nums[m];
            }
            else{
                r = m - 1;
            }
        }

        return nums[l];
    }
}