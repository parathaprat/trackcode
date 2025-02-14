class Solution {
    public void rotate(int[] nums, int k) {
        

        //Main logic -> 
        //Reverse array 
        //reverse the first k % len elements// and the remaining elements

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int l, int r){

        while(l < r){

            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;

            l++;
            r--;

        }

        
    }

}