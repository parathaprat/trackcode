class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(0, nums, res, path);

        return res;
    }

    private void backtrack(int ind, int[] nums, List<List<Integer>> res, List<Integer> path){

        if(ind >= nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[ind]);
        backtrack(ind + 1, nums, res, path);
        path.remove(path.size() - 1);

        backtrack(ind + 1, nums, res, path);
    }
}