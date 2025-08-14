class Solution {
    public boolean isAnagram(String s, String t) {
        
        //cannot use hashset: 1 of the words can have multiple letters, hence we use frequency arrays

        int[] freq = new int[26];

        if(s.length() != t.length()) return false;

        //populate frequencies for s
        for(int i = 0; i < s.length(); i++){

            freq[s.charAt(i) - 'a']++;

        }

        //subtract chars of t, if it ever goes below 0, ret false
        for(int i = 0; i < t.length(); i++){

            freq[t.charAt(i) - 'a']--;
            if(freq[t.charAt(i) - 'a'] < 0) return false;

        }

        return true;

        
    }
}