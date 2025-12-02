class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        //dp[i] = if substring till i is breakable, true

        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; //nothing is breakable
        
        for(int i = 0; i <= s.length(); i++){

            for(int j = 0; j < i; j++){

                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
        
    }
}