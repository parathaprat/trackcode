class Solution {
    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int l = -1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(nums[mid] >= target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

            if(nums[mid] == target){
                l = mid;
            }
        }

        left = 0;
        right = nums.length - 1;
        int r = -1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(nums[mid] <= target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }

            if(nums[mid] == target){
                r = mid;
            }
        }

        return new int[]{l, r};
    }
}