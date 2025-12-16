class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

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

        for(int i = ind; i < candidates.length; i++){

            if(i > ind && candidates[i] == candidates[i - 1]) continue;

            if(candidates[i] > target) break;

            path.add(candidates[i]);
            backtrack(res, path, i + 1, candidates, target - candidates[i]);
            path.remove(path.size() - 1);
        }

    }
}