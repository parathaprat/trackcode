class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        //modified biary search; intuition = logn
        int[] result = new int[2];

        //helper functions to get each element in result
        result[0] = getStartInd(nums, target);
        result[1] = getEndInd(nums, target);

        return result;
    }

    //force collapse end for starting index
    public int getStartInd(int[] nums, int target){

        int index = -1;

        int start = 0;
        int end = nums.length - 1;

        //start binary searching
        while(start <= end){
            int midpoint = start + (end - start)/2;

            //key is <=, = so that the search continues even if element is found
            if(nums[midpoint] >= target){
                end = midpoint - 1;
            }
            else{
                start = midpoint + 1;
            }

            if(nums[midpoint] == target) index = midpoint;
        }

        return index;
    }

    //force collapse start for ending index
    public int getEndInd(int[] nums, int target){

        int index = -1;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){

            int midpoint = start + (end - start)/2;

            //key is <=, = so that the search continues even if element is found
            if(nums[midpoint] <= target){
                start = midpoint + 1;
            }
            else{
                end = midpoint - 1;
            }

            if(nums[midpoint] == target) index = midpoint;
        }

        return index;
    }


}