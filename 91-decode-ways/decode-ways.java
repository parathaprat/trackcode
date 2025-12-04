class Solution {
    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1]; //number of ways to decode from i to end

        dp[s.length()] = 1;
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;

        for(int i = s.length() - 2; i >= 0; i--){

            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }

            dp[i] = dp[i + 1];

            int num = Integer.parseInt(s.substring(i, i + 2));

            if(num >= 10 && num <= 26) dp[i] += dp[i + 2];
        }

        return dp[0];
    }
}