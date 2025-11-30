class Solution {
    public int[] getConcatenation(int[] nums) {

        int[] ans = new int[nums.length + nums.length];

        int pt = 0;

        for(int num : nums){
            ans[pt] = num;
            ans[pt + nums.length] = num;
            pt++;
        }

        return ans;
    }
}