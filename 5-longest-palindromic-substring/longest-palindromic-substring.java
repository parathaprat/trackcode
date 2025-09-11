class Solution {
    public String longestPalindrome(String s) {
        
        int start = 0;
        int end = 0;
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            int oddLen = getLen(c, i, i, s);
            int evenLen = getLen(c, i, i + 1, s);

            int max = Math.max(oddLen, evenLen);

            if(max > maxLen){
                maxLen = max;

                start = i - (maxLen - 1)/2;
                end = i + maxLen/2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int getLen(char c, int left, int right, String s){

        if(left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) return 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}