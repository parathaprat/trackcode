class Solution {
    public int triangleNumber(int[] nums) {

        //sort array 
        //loop from the back uptil 2
        //left at 0, right at i - 1
        //nums[left] + nums[right] > nums[i], count+= right - left; right--;
        

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