class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //Maintain a hashmap of {prefixSum, count}
        //if map contains (sum - k), add its count to result

        int result = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];

            if(map.containsKey(sum - k)) result += map.getOrDefault(sum - k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return result;


    }
}