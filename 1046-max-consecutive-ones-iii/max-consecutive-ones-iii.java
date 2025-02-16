class Solution {
    public int longestOnes(int[] nums, int k) {
        

        //use a sliding window 

        int i = 0; 
        int j = 0;

        while(j < nums.length){

            if(nums[j] == 0) k--;

            if(k < 0){

                if(nums[i] == 0) k++;
                i++;

            }

            j++;

        }

        return j - i;
    }
}