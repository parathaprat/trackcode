class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //sliding window
        //hashset 
        //when set.contains(c) left++

        int left = 0;
        int right = 0;

        int maxLen = 0;

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

            maxLen = Math.max(maxLen, set.size());
            
        }

        return maxLen;
    }
}