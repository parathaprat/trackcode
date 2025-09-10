class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
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

        for(int i = index; i < candidates.length; i++){

            if(i > index && candidates[i] == candidates[i - 1] || candidates[i] > target) continue;
            
            set.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, result, set);
            set.remove(set.size() - 1);
        }
    }
}