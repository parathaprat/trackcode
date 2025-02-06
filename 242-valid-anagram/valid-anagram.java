class Solution {
    public boolean isAnagram(String s, String t) {
        
        //base -> if len of s and t !=, return false
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];

        //freq counting s
        for(int i = 0; i < s.length(); i++){

            freq[s.charAt(i) - 'a']++;

        }

        //freq reducing from t
        for(int i = 0; i < t.length(); i++){

            freq[t.charAt(i) - 'a']--;

            //if any freq ever goes below 0, false
            if(freq[t.charAt(i) - 'a'] < 0) return false;

        }

        return true;
    }
}