class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int longestAns = 0;

        for(int right = 0; right < s.length(); right++){

            //update in freq array, and update maxFreq so far
            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            //calcualte window length, and check if it can accomodate k changes
            //if not, ++ left pointer

            int windowSize = right - left + 1;

            if(windowSize - maxFreq > k){

                freq[s.charAt(left) - 'A']--;
                left++;

            }

            //calculate updated windowSize after operations, and update longestAns
            windowSize = right - left + 1;
            longestAns = Math.max(longestAns, windowSize);
        }

        return longestAns;


    }
}