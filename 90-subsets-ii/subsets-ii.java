class Solution {

    List<List<Integer>> res = new ArrayList<>();

    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        //sort elements to get dublicates tog
        Arrays.sort(nums);
        
        getAns(nums, 0);

        return res;
    }
    
    private void getAns(int[] nums, int i){

        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        //include
        subset.add(nums[i]);
        getAns(nums, i + 1);

        //not include
        //to skip duplicates
        while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;

        subset.remove(subset.size() - 1);
        getAns(nums, i + 1);
    }
}