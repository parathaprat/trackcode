class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //backtracking
        //take the same num, target - num
        //don't take the num at all

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        backtrack(0, res, ans, candidates, target);

        return res;
    }

    private void backtrack(int i, List<List<Integer>> res, List<Integer> ans, int[] candidates, int target){

        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(i >= candidates.length || target < 0) return;

        ans.add(candidates[i]);
        backtrack(i, res, ans, candidates, target - candidates[i]);

        ans.remove(ans.size() - 1);
        backtrack(i + 1, res, ans, candidates, target);
    }
}