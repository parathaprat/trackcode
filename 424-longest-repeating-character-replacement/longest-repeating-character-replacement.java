class Solution {
    public int characterReplacement(String s, int k) {

        //windowLen - maxFreq > k, left++

        int left = 0;

        int[] freq = new int[26];
        int maxFreq = 0;

        int ans = 0;

        for(int right = 0; right < s.length(); right++){

            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(freq[s.charAt(right) - 'A'], maxFreq);

            int windowSize = right - left + 1;

            if(windowSize - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            windowSize = right - left + 1;

            ans = Math.max(ans, windowSize);
        }

        return ans;
        
    }
}