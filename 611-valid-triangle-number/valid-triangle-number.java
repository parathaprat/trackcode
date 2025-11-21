class Solution {
    public int triangleNumber(int[] nums) {

        //sort arrays
        //interate from back until 2
        //left, right, if num[left] + num[right] > num[i], count += right - left, right--

        Arrays.sort(nums);
        int count = 0;

        for(int i = nums.length - 1; i >= 2; i--){

            int left = 0;
            int right = i - 1;

            while(left < right){

                if(nums[left] + nums[right] > nums[i]){
                    count += right - left;
                    right--;
                }
                else{
                    left++;
                }
            }
        }

        return count;
        
    }
}