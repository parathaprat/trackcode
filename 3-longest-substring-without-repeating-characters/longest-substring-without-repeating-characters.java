class Solution {
    public int lengthOfLongestSubstring(String s) {

        //2 pointers starting from 0
        //add char at right, r++
        //remove from left if duplicate
        //update ans accordingly

        int l = 0;
        int r = 0;

        int ans = 0;
        Set<Character> set = new HashSet<>();

        while(r < s.length()){

            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }
            else{
                set.remove(s.charAt(l));
                l++;
            }

            ans = Math.max(ans, r - l);
        }

        return ans; 
    }
}