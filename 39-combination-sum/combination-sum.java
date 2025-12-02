class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        backtrack(0, res, set, candidates, target);

        return res;
    }

    private void backtrack(int ind, List<List<Integer>> res, List<Integer> set, int[] candidates, int target){

        if(target == 0){
            res.add(new ArrayList<>(set));
            return;
        }

        if(ind >= candidates.length || target <= 0) return;

        set.add(candidates[ind]);
        backtrack(ind, res, set, candidates, target - candidates[ind]);
        set.remove(set.size() - 1);

        backtrack(ind + 1, res, set, candidates, target);


    }


}