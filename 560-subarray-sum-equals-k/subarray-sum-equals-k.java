class Solution {
    public int subarraySum(int[] nums, int k) {

        //create prefixSum map, prefixSum -> count
        //traverse through, check for sum so far
        //add count of surSum - k prefixsum to ans

        int curSum = 0;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int num : nums){

            curSum += num;
            ans += map.getOrDefault(curSum - k, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return ans;
        
    }
}