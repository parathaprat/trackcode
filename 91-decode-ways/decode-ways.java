class Solution {
    public int numDecodings(String s) {
        
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        dp[s.length()] = 1;

        return getAns(dp, s, 0);
    }

    private int getAns(int[] dp, String s, int i){

        if(dp[i] != -1) return dp[i];

        if(s.charAt(i) == '0') return 0;

        int res = getAns(dp, s, i + 1);

        if(i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' &&s.charAt(i + 1) < '7')){
            res += getAns(dp, s, i + 2);
        }

        return dp[i] = res;
    }
}