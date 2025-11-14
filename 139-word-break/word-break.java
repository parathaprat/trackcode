class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return getAns(s, dp, set, 0);
        
    }

    public Boolean getAns(String s, Boolean[] dp, Set<String> set, int ind){

        if(ind >= s.length()) return true;
        if(dp[ind] != null) return dp[ind];

        for(int i = ind; i < s.length(); i++){

            if(set.contains(s.substring(ind, i + 1))){

                if(getAns(s, dp, set, i + 1)){
                    return dp[ind] = true;
                }
            }
        }

        return dp[ind] = false;
    }
}