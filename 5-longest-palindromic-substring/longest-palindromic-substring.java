class Solution {
    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){

            int oddLen = getLen(i, i, s);
            int evenLen = getLen(i, i + 1, s);

            int max = Math.max(oddLen, evenLen);

            if(max > maxLen){
                maxLen = max;

                start = i - (maxLen - 1)/2;
                end = i + maxLen/2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int getLen(int start, int end, String s){

        if(start < 0 || end >= s.length() || s.charAt(start) != s.charAt(end)) return 0;

        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }

        return end - start - 1;
    }
}