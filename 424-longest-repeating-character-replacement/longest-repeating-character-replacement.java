class Solution {
    public int characterReplacement(String s, int k) {

        //windowFreq - maxFreq > k, left++;

        int left = 0;

        int[] freq = new int[26];
        int maxFreq = 0;

        int ans = 0;

        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            int windowSize = right - left + 1;

            if(windowSize - maxFreq > k){

                char leftc = s.charAt(left);
                freq[leftc - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}