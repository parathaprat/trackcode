class Solution {
    public int subarraySum(int[] nums, int k) {

        //ans += prefixSum[sumSoFar - k]

        int ans = 0;
        int curSum = 0;

        Map<Integer,Integer> map = new HashMap<>(); //prefixSum -> count
        map.put(0, 1); //empty array = prefix sum of 0

        for(int num : nums){

            curSum += num;
            ans += map.getOrDefault(curSum - k, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return ans;
        
    }
}