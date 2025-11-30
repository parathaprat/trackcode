class Solution {
    public int characterReplacement(String s, int k) {

        //2 pointer, iterate w left
        //windowsize - maxFreq > k, left++
        //max windowsize is ans

        int left = 0;
        int ans = 0;

        int[] freq = new int[26];
        int maxFreq = 0;

        for(int right = 0; right < s.length(); right++){

            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            if(right - left + 1 - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(right - left + 1, ans);
            
        }

        return ans;
    }
}