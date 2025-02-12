class Solution {
    public int[] sortedSquares(int[] nums) {
        
        //left = start
        //right = end
        //input is sorted, fill res from the back

        int[] res = new int[nums.length];

        int l = 0;
        int r = nums.length - 1;
        int z = nums.length - 1;

        while(l <= r){

            if(nums[l] * nums[l] > nums[r] * nums[r]){
                res[z] = nums[l] * nums[l];
                l++;
            }
            else{
                res[z] = nums[r] * nums[r];
                r--;
            }
            z--;
        }

        return res;
    }
}