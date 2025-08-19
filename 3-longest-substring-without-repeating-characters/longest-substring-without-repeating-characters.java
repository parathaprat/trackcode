class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //sliding window
        //start both pointers from start, if charAt(right) is not in set, add
        //if it is ++left
        //max len all along

        int left = 0;
        int right = 0;

        int ans = 0;

        Set<Character> set = new HashSet<>();

        while(right < s.length()){

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }

            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}