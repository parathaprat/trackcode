class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        backtrack(candidates, target, 0, result, set);

        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> set){

        if(target == 0){
            result.add(new ArrayList<>(set));
            return;
        }

        if(index == candidates.length || target < 0) return;

        set.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, result, set); //include same
        set.remove(set.size() - 1);
        backtrack(candidates, target, index + 1, result, set); //skip completly
    }
}