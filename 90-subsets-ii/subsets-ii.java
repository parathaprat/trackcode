class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        backtrack(result, set, 0, nums);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> set, int start, int[] nums){

        result.add(new ArrayList<>(set));

        for(int i = start; i < nums.length; i++){

            if(i > start && nums[i] == nums[i - 1]) continue;

            set.add(nums[i]);
            backtrack(result, set, i + 1, nums);
            set.remove(set.size() - 1);
        }
    }
}