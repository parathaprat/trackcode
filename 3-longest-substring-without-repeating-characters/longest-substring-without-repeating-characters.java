class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i = 0;
        int j = 0;

        Set<Character> set = new HashSet<>();
        int max = 0;

        while(j < s.length()){
            
            if(!set.contains(s.charAt(j))){
                
                set.add(s.charAt(j));
                j++;

                max = Math.max(max, set.size());
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }

        }

        return max;
    }
}