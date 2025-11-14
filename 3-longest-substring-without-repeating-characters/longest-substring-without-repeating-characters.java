class Solution {
    public int lengthOfLongestSubstring(String s) {

        //sliding window 
        //NOT 2 pointers
        //hence r < len nad not l < r

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