class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        
        //maintain a prefix array 
        int[] prefix = new int[nums.length];
        prefix[0] = 0;

        //loop through nums 
        for(int i = 1; i < nums.length; i++){

            if(nums[i] % 2 == nums[i - 1] % 2){

                //assign prefix + 1 for every case where adj pair is odd/even
                prefix[i] = prefix[i - 1] + 1;
            }
            else{

                //assign same value if not
                prefix[i] = prefix[i - 1];
            }
        }

        boolean[] ans = new boolean[queries.length];

        //use parity array to develop ans array 
        for(int i = 0; i < queries.length; i++){
            ans[i] = prefix[queries[i][0]] == prefix[queries[i][1]];
        }

        return ans;
    }
}