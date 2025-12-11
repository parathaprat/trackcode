class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int[] freq = new int[26];
        int maxFreq = 0;

        int ans = 0;

        for(int right = 0; right < s.length(); right++){
            
            char rightc = s.charAt(right);
            freq[rightc - 'A']++;

            maxFreq = Math.max(maxFreq, freq[rightc - 'A']);

            int windowSize = right - left + 1;

            if(windowSize - maxFreq > k){

                char leftc = s.charAt(left);
                freq[leftc - 'A']--;
                left++;
            }

            windowSize = right - left + 1;

            ans = Math.max(windowSize, ans);
        }

        return ans;
    }
}