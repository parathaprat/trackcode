class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length - 1;

        //<= so we check every candidate (think arrays with only 1 element where l == r)
        while(l <= r){
            
            int mid = l + (r - l)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return -1;
    }
}