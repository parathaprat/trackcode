class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){

            if(i == 0 || nums[i] != nums[i - 1]){

                int left = i + 1;
                int right = nums.length - 1;

                int target = -nums[i];

                while(left < right){

                    if(nums[left] + nums[right] == target){

                        result.add(Arrays.asList(nums[i], nums[right], nums[left]));

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

        return result;
    }
}