class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        //Approach -> Declare a set, if a number is contained in the set, return true

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){

            if(set.contains(nums[i])) return true;
            set.add(nums[i]);

        }

        return false;
    }
}