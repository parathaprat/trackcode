class Solution {
    public int subarraySum(int[] nums, int k) {

        // for current[prefix Sum],  += count of prefixSUms that add up to (prefixSum - k)

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int curSum = 0;

        int count = 0;

        for(int num : nums){
            curSum += num;
            count += map.getOrDefault(curSum - k, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return count;
        
    }
}