class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        backtrack(res, set, 0, candidates, target);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> set, int ind, int[] candidates, int target){

        if(target == 0){
            res.add(new ArrayList<>(set));
            return;
        }

        if(ind >= candidates.length || target < 0) return;

        set.add(candidates[ind]);
        backtrack(res, set, ind, candidates, target - candidates[ind]);
        set.remove(set.size() - 1);

        backtrack(res, set, ind + 1, candidates, target);
    }
}