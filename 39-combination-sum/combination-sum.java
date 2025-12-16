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

        if(target < 0) return;

        for(int i = ind; i < candidates.length; i++){

            path.add(candidates[i]);
            backtrack(res, path, i, candidates, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}