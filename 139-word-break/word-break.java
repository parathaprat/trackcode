class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        //we create a set of dict

        //we create a boolean dp[] array -> dp[i] = substring from i to end, is valid or no

        Set<String> set = new HashSet<>(wordDict);

        //we use Boolean since it has true, false, null
        Boolean[] dp = new Boolean[s.length()];

        //return -> substring 0 to end is breakable into words from dict
        return getAns(s, dp, 0, set);
    }

    private boolean getAns(String s, Boolean[] dp, int ind, Set<String> set){

        //if the function reached here, it means entire string has been segmented, so return true
        if(ind == s.length()) return true;

        //return dp value if exists
        if(dp[ind] != null) return dp[ind];

        //starting from ind, check every substring
        for(int i = ind; i < s.length(); i++){

            //if substring is found in dict
            if(set.contains(s.substring(ind, i + 1))){

                //the substring can be broken down into valid dict words
                if(getAns(s, dp, i + 1, set)){

                    //we return true
                    return dp[ind] = true;
                }
            }
        }

        return dp[ind] = false;
    }
}