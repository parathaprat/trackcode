class Solution {
    public long maximumOr(int[] nums, int k) {

        int n = nums.length;

        long result = 0;
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] | nums[i - 1];
            suffix[n - i - 1] = suffix[n - i] | nums[n - i];
        }

        for(int i = 0; i < n; i++){
            result = Math.max(result, prefix[i] | ((long)nums[i] << k) | suffix[i]);
        }

        return result;
        
    }
}