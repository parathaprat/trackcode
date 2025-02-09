class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //2 pointer approach

        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();

        int ans = 0;
        
        while(right < s.length()){

            if(!set.contains(s.charAt(right))){

                set.add(s.charAt(right));
                right++;

                ans = Math.max(ans, set.size());
            }
            else{

                set.remove(s.charAt(left));
                left++;
            
            }

        
        }

        return ans;
    }
}