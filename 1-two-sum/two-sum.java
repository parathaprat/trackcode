class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //hashmap stores (num, ind(num));
        Map<Integer, Integer> map = new HashMap<>();

        //loop through nums array, find complement and check availability in hashmap
        for(int i = 0; i < nums.length; i++){

            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[2];
    }
}