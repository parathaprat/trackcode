class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        backtrack(res, set, nums, 0);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> set, int[] nums, int ind){

        res.add(new ArrayList<>(set));

        for(int i = ind; i < nums.length; i++){

            if(i > ind && nums[i] == nums[i - 1]) continue;

            set.add(nums[i]);
            backtrack(res, set, nums, i + 1);
            set.remove(set.size() - 1);
        }
    }
}