class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(0, candidates, target, res, path);

        return res;
        
    }

    private void backtrack(int i, int[] candidates, int target, List<List<Integer>> res, List<Integer> path){

        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        if(target < 0 || i >= candidates.length) return;

        path.add(candidates[i]);
        backtrack(i, candidates, target - candidates[i], res, path);
        path.remove(path.size() - 1);

        backtrack(i + 1, candidates, target, res, path);
    }
}