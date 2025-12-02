class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right){

            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[right]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        int pivot = left;

        if(target >= nums[pivot] && target <= nums[nums.length - 1]){
            left = pivot;
            right = nums.length - 1;
        }
        else{
            right = pivot - 1;
            left = 0;
        }

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return -1;
        
    }
}