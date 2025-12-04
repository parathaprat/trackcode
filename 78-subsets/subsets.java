class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(0, nums, path, res);

        return res;
    }

    private void backtrack(int in, int[] nums, List<Integer> path, List<List<Integer>> res){

        if(in >= nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[in]);
        backtrack(in + 1, nums, path, res);
        path.remove(path.size() - 1);

        backtrack(in + 1, nums, path, res);
    }
}