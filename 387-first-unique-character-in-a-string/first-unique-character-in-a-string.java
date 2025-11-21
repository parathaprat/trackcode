class Solution {
    public int firstUniqChar(String s) {

        //make a freq array, iterate throgh the letters in s, return first freq = 1

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1) return i;
        }
        
        return -1;
        
    }
}