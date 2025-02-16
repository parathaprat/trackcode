class Solution {
    public int search(int[] nums, int target) {
        
        //approach -> Binary search to find pivot, find out which side our element is on and BS again

        //finding pivot

        int l = 0;
        int r = nums.length - 1;

        while(l < r){

            int mid = l + (r - l) / 2;

            if(nums[mid] > nums[r]) l = mid + 1;
            else r = mid;

        }

        int pivot = l;

        if(target >= nums[pivot] && target <= nums[nums.length - 1]){

            l = pivot;
            r = nums.length - 1;
            
        }
        else{
            r = pivot - 1;
            l = 0;
        }



        //BS ont that portion 

        while(l <= r){

            int mid = l + (r - l) / 2;

            if(target > nums[mid]) l = mid + 1;
            else if(target < nums[mid]) r = mid - 1;
            else return mid;

        }

        return -1;


    }
}