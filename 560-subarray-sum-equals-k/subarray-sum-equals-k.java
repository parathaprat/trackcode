class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int curSum = 0;
        int ans = 0;

        for(int num : nums){
            curSum += num;
            ans += map.getOrDefault(curSum - k, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        
        return ans;
        
    }
}