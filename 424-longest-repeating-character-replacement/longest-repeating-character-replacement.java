class Solution {
    public int characterReplacement(String s, int k) {

        //left and right pointer
        //loop with right, leep track of maxFreq
        //whenever window - maxFreq > k, left++
        //size of window gives ans

        int left = 0;
        int ans = 0;
        int maxFreq = 0;

        int[] freq = new int[26];

        for(int right = 0; right < s.length(); right++){

            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;

            if(windowSize - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;

        
    }
}