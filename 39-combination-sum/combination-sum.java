class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(0, candidates, target, res, path);

        return res;
    }

    private void backtrack(int in, int[] candidates, int target, List<List<Integer>> res, List<Integer> path){

        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        if(in >= candidates.length || target < 0) return;

        path.add(candidates[in]);
        backtrack(in, candidates, target - candidates[in], res, path);
        path.remove(path.size() - 1);

        backtrack(in + 1, candidates, target, res, path);
    }
}