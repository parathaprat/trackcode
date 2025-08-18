class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        //sort the nums, iterate through each and treat target as -ve that num
        //use 2 pointer approach, since array is sorted

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){

            //making sure elements are not equal and accounting for 0th edge case
            if(i == 0 || nums[i] != nums[i - 1]){

                //left pointer starts from +1, hence loop runs till -2
                int left = i + 1;
                int right = nums.length - 1;

                int target = - nums[i];

                while(left < right){

                    if(nums[left] + nums[right] == target){
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        //pair found, iterate till duplicates are skipped, move pointers
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;

                    }
                    else if(nums[left] + nums[right] > target){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}