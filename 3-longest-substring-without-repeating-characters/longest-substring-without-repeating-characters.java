class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();

        int ans = 0;

        while(right < s.length()){

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }

            ans = Math.max(right - left, ans);

        }

        return ans;
        
    }
}