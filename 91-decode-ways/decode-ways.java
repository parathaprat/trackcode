class Solution {
    public int numDecodings(String s) {

        int n = s.length();

        int[] dp = new int[n + 1]; //no of ways to decode subtring from i
        dp[n] = 1; //one way to decode nothing
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1; //ways to decode 1 char

        for(int i = n - 2; i >= 0; i--){

            if(s.charAt(i) == '0'){ //if 0, ways to decode is 0
                dp[i] = 0;
                continue;
            }

            dp[i] = dp[i + 1]; //if valid, same as next index

            int check = Integer.parseInt(s.substring(i, i + 2));

            if(check >= 10 && check <= 26){ //if 2 digits in range, add dp[i+2]
                dp[i] += dp[i + 2];
            }
        }

        return dp[0]; //return dp for subtring from start
    }
}