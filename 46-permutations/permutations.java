class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0);

        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int start){

        if(start == nums.length){
            res.add(arrToList(nums));
        }

        for(int i = start; i < nums.length; i++){

            swap(nums, i, start);
            backtrack(res, nums, start + 1);
            swap(nums, i , start);
        }
    }

    private void swap(int[] nums, int i, int j){

        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private List<Integer> arrToList(int[] nums){

        List<Integer> ans = new ArrayList<>();

        for(int num : nums){
            ans.add(num);
        }

        return ans;
    }
}