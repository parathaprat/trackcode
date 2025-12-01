class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

        for(int i = n - 2; i >= 0; i--){

            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }

            dp[i] = dp[i + 1];

            int check = Integer.parseInt(s.substring(i, i + 2));
            if(check >= 10 && check <= 26){
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
        
    }
}