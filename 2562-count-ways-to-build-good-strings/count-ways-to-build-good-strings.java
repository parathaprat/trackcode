class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        int[] dp = new int[high + 1];

        //since there is only 1 way to form a string with 0 length (empty)
        dp[0] = 1;

        int mod = 1000000007;

        for(int i = 1; i <= high ; i++){

            //main logic -> if a string of length (i - zero) can be created in x ways, this can be exttended by adding said block to strings of length i
            if(i - zero >= 0){
                dp[i] += dp[i - zero];
            }

            if(i - one >= 0){
                dp[i] += dp[i - one];
            }

            dp[i] %= mod;
        }

        int res = 0;

        //add all valid lengths to res and return
        for(int i = low; i <= high; i++){
            res += dp[i];
            res %= mod;
        }

        return res;
    }
}