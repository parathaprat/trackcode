class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        getAns(result, candidates, target, 0, ans, 0);

        return result;
    }

    private void getAns(List<List<Integer>> result, int[] candidates, int target, int sum, List<Integer> ans, int ind){

        if(sum == target){
            result.add(new ArrayList<>(ans));
            return;
        }

        if(ind >= candidates.length) return;

        //no consider
        getAns(result, candidates, target, sum, ans, ind + 1);

        if(sum + candidates[ind] <= target){
            sum += candidates[ind];
            ans.add(candidates[ind]);

            //consider
            getAns(result, candidates, target, sum, ans, ind);

            sum -= candidates[ind];
            ans.remove(ans.size() - 1);
        }

    }
}