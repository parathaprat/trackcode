class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        //get length of both strings
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        for(int[] row : dp) Arrays.fill(row, -1);

        return getAns(n - 1, m - 1, text1, text2, dp);

    }

    public int getAns(int n, int m, String text1, String text2, int[][] dp){

        //base case
        if(n < 0 || m < 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        //case where char is same
        if(text1.charAt(n) == text2.charAt(m)){
            return dp[n][m] = 1 + getAns(n - 1, m - 1, text1, text2, dp);
        }
        else{
            return dp[n][m] = Math.max(getAns(n - 1, m, text1, text2, dp), getAns(n, m - 1, text1, text2, dp));
        }

    }
}