class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(res, path, 0, candidates, target);

        return res;
        
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int ind, int[] candidates, int target){

        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        if(ind >= candidates.length || target < 0) return;

        path.add(candidates[ind]);
        backtrack(res, path, ind, candidates, target - candidates[ind]);
        path.remove(path.size() - 1);

        backtrack(res, path, ind + 1, candidates, target);
    }
}