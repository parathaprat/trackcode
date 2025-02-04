class Solution {
    public int search(int[] nums, int target) {
        
        //find pivot element using BS, BS again to find target 

        int left = 0; 
        int right = nums.length - 1;

        //pivot will be on left after this loop
        while(left < right){

            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }

        }

        //locate which side our target is on

        int start = left;
        left = 0;
        right = nums.length - 1;

        if(target >= nums[start] && target <= nums[right]){
            left = start;
        }else{
            right = start - 1;
        }

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(nums[mid] > target){
                right = mid - 1;
            }
            else if(nums[mid] == target){
                return mid;
            }
            else{
                left = mid + 1;
            }

        }

        return -1;

    }
}