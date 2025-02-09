class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();

        int finalLength = 0;

        while(right < s.length()){

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                finalLength = Math.max(finalLength, set.size());
            }

            else{
                set.remove(s.charAt(left));
                left++;
            }
        }

        return finalLength;
    }
}