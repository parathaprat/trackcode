class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //to track all characters
        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;

        int ans = 0;

        while(right < s.length()){

            if(!set.contains(s.charAt(right))){

                set.add(s.charAt(right));
                right++;

                ans = Math.max(ans, set.size());

            }
            else if(set.contains(s.charAt(right))){

                set.remove(s.charAt(left));
                left++;
            }
        }

        return ans;
    }
}