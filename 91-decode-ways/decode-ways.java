class Solution {
    public int numDecodings(String s) {
        
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        //only 1 way to decode an empty string
        dp[s.length()] = 1;

        return getAns(0, s, dp);
    }

    public int getAns(int i, String s, int[] dp){

        if(dp[i] != -1) return dp[i];

        if(s.charAt(i) == '0') return 0;

        //taking single char
        int res = getAns(i + 1, s, dp);

        if(i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))){
            res += getAns(i + 2, s, dp);
        }

        return dp[i] = res;

    }
}