class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //use a set to track unique chars
        Set<Character> set = new HashSet<>();

        //left stays, right track
        int left = 0;
        int right = 0;

        int finalAns = 0;

        while(right < s.length()){

            if(!set.contains(s.charAt(right))){

                set.add(s.charAt(right));
                right++;

                finalAns = Math.max(finalAns, set.size());
            }
            else{

                set.remove(s.charAt(left));
                left++;

            }
        }

        return finalAns;


    }
}