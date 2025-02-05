class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        //create a hashset for dictionary
        Set<String> set = new HashSet<>(wordDict);

        Boolean[] dp = new Boolean[s.length()];

        return getAns(s, set, 0, dp);
    }

    public boolean getAns(String s, Set<String> set, int ind, Boolean[] dp){

        //base case
        if(ind == s.length()) return true;

        if(dp[ind] != null) return dp[ind];

        for(int i = ind; i < s.length(); i++){

            //i to j + 1 since java's substring method gets it from i to j

            //if dictionary set contains substring and if function is valid for rest of the string starting from j + 1, return true
            if(set.contains(s.substring(ind, i + 1))){
                if(getAns(s, set, i + 1, dp)){
                    return dp[ind] = true;
                }
            }
        }

        return dp[ind] = false;

    }
}