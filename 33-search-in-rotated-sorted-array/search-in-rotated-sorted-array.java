class Solution {
    public int search(int[] nums, int target) {
        
        //BS to find pivot, then BS again on the correct side to find element

        int l = 0;
        int r = nums.length - 1;

        //finding pivot
        while(l < r){

            int m = l + (r - l)/2;

            if(nums[m] > nums[r]){
                l = m + 1;
            }
            else{
                r = m;
            }
        }

        int pivot = l;

        //finding partition
        if(target >= nums[pivot] && target <= nums[nums.length - 1]){
            l = pivot;
            r = nums.length - 1;
        }
        else{
            r = pivot - 1;
            l = 0;
        }

        //finding element
        while(l <= r){

            int m = l + (r - l)/2;

            if(nums[m] == target){
                return m;
            }
            else if(nums[m] < target){
                l = m + 1;
            }
            else{
                r = m - 1;
            }
        }

        return -1;
    }
}