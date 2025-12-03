class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        int ans = 0;

        int maxFreq = 0;
        int[] freq = new int[26];

        while(right < s.length()){

            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(freq[s.charAt(right) - 'A'], maxFreq);

            int windowSize = right - left + 1;

            if(windowSize - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            windowSize = right - left + 1;
            ans = Math.max(ans, windowSize);

            right++;

        }

        return ans;
        
    }
}