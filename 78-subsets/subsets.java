class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        backtrack(nums, 0, res, set);

        return res;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> res, List<Integer> set){

        if(index == nums.length){
            res.add(new ArrayList<>(set));
            return;
        }

        backtrack(nums, index + 1, res, set);

        set.add(nums[index]);
        backtrack(nums, index + 1, res, set);
        set.remove(set.size() - 1);
    }
}