class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1]; //word break from 0 to i
        dp[0] = true; //possible to break nothing

        Set<String> dict = new HashSet<>(wordDict);

        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){

                if(dict.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()]; 
    }
}