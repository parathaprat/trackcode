class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return getAns(s, dp, 0, set);

    }

    private boolean getAns(String s, Boolean[] dp, int ind, Set<String> set){

        if(ind >= s.length()) return true;

        if(dp[ind] != null) return dp[ind];

        for(int i = ind; i < s.length(); i++){

            if(set.contains(s.substring(ind, i + 1))){

                if(getAns(s, dp, i + 1, set)){
                    return dp[ind] = true;
                }
            }
        }

        return dp[ind] = false;
    } 
}