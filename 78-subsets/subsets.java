class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        getAns(res, set, 0, nums);

        return res;
    }

    private void getAns(List<List<Integer>> res, List<Integer> set, int ind, int[] nums){

        if(ind >= nums.length){
            res.add(new ArrayList<>(set));
            return;
        }

        set.add(nums[ind]);
        getAns(res, set, ind + 1, nums);
        set.remove(set.size() - 1);

        getAns(res, set, ind + 1, nums);
    }
}