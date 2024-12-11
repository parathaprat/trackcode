class Solution {
    public int maximumBeauty(int[] nums, int k) {
        
        //using a sliding window approach
        Arrays.sort(nums);

        //i = right; j = left
        int i = 0;
        int ans = 0;

        for(int j = 0; j < nums.length; j++){

            //shrink window while min(j) is greater than max(i)
            while(nums[j] - k > nums[i] + k){
                i++;
            }

            //get length of elements in window
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}