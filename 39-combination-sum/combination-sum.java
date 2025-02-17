class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();



        //find unique elements summing to target
        getAns(candidates, ans, target, 0, result);

        return result;
    }

    private void getAns(int[] candidates, List<Integer> ans, int target, int ind, List<List<Integer>> result){

        //base case
        if(target == 0){
            result.add(new ArrayList<>(ans));
            return;
        }
    
        if(ind >= candidates.length) return;

        //consider curr element
        if(target - candidates[ind] >= 0){
            ans.add(candidates[ind]);
            //problem statement allows same element to be chosen multiple times, so we do not ++ ind
            getAns(candidates, ans, target - candidates[ind], ind, result);

            //backtrack
            ans.remove(ans.size() - 1);
        }

        //not consider curr element
        getAns(candidates, ans, target, ind + 1, result);

    }
}