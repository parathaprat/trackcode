class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(nums);

        getAns(res, 0, subset, nums);

        return res;
    }

    private void getAns(List<List<Integer>> res, int index, List<Integer> subset, int[] nums){

        //base
        if(index >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        //include
        subset.add(nums[index]);
        getAns(res, index + 1, subset, nums);

        //notInclude
        subset.remove(subset.size() - 1);
        
        while(index + 1 < nums.length && nums[index] == nums[index + 1]) index++;

        getAns(res, index + 1, subset, nums);
        
    }
}