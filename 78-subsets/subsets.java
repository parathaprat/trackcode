class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        dfs(nums, 0, res, set);

        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> set){

        //reached the end for a particular subset
        if(index >= nums.length){

            res.add(new ArrayList<>(set));
            return;
        }

        //current element -> part of the subset
        set.add(nums[index]);
        dfs(nums, index + 1, res, set);

        set.remove(set.size() - 1);
        dfs(nums, index + 1, res, set);
    }
}