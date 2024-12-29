class Solution {
    public int numWays(String[] words, String target) {
        
        int alphabets = 26;
        int mod = 1000000007;
        int m = target.length();
        int k = words[0].length();

        int[][] current = new int[alphabets][k];

        //frequency array
        for(int j = 0; j < k; j++){
            for(String word : words){
                current[word.charAt(j) - 'a'][j]++;
            }
        } 

        //dp[i][j] = number of ways to form the first i characters of target using the first j columns of words
        long[][] dp = new long[m + 1][k + 1];

        //only 1 way to form an empty string with no cols
        dp[0][0] = 1;

        for(int i = 0; i <= m; i++){
            for(int j = 0; j < k; j++){

                if(i < m){
                    dp[i + 1][j + 1] += current[target.charAt(i) - 'a'][j] * dp[i][j];
                    dp[i + 1][j + 1] %= mod;
                }

                dp[i][j + 1] += dp[i][j];
                dp[i][j + 1] %= mod; 
            }
        }

        return (int)dp[m][k];
    }
}