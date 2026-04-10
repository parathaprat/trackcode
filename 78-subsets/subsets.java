class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(res, path, 0, nums);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int ind, int[] nums){

        res.add(new ArrayList<>(path));

        for(int i = ind; i < nums.length; i++){

            path.add(nums[i]);
            backtrack(res, path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}