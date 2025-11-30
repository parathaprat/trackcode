class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2]; 

        result[0] = getStartInd(nums, target);
        result[1] = getEndInd(nums, target);

        return result;
    }

    private int getStartInd(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        int index = -1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(nums[mid] >= target){ //keep exploring left half even when found
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

            if(nums[mid] == target) index = mid;
        }

        return index;
    }

    private int getEndInd(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(nums[mid] <= target){ //keep exploring right half even when found
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }

            if(nums[mid] == target) index = mid;
        }

        return index;
    }
}