class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length() + 1];

        return getAns(0, set, dp, s);
        
    }

    private Boolean getAns(int ind, Set<String> set, Boolean[] dp, String s){

        if(ind >= s.length()) return true;

        if(dp[ind] != null) return dp[ind];

        for(int i = ind; i < s.length(); i++){

            if(set.contains(s.substring(ind, i + 1))){
                if(getAns(i + 1, set,dp, s)) return dp[ind] = true;
            }
        }

        return dp[ind] = false;
    }
}