class Solution {
    public String longestPalindrome(String s) {
        
        //go thru each character
        //treat it as the middle of either an odd or even palindrome
        //use 2 pointers to check if it actually is
        //odd -> left = right; even -> left, left + 1

        int start = 0;
        int end = 0;

        int maxPalLen = 0;

        for(int i = 0; i < s.length(); i++){

            //odd middle
            int left = palLen(s, i, i);

            //even middle
            int right = palLen(s, i, i + 1);


            int isPal = Math.max(left, right);

            if(isPal > maxPalLen){

                maxPalLen = isPal;

                start = i - (maxPalLen - 1)/2;
                end = i + maxPalLen/2;
            }
        }

        //.substring is exclusive at the end index
        return s.substring(start, end + 1);
    }

    private int palLen(String s, int start, int end){

        if(start > end) return 0;

        while(start >= 0  && end < s.length() && s.charAt(start) == s.charAt(end)){

            start--;
            end++;

        }

        //since both pointers have been moved outside window area now
        return end - start - 1;
    }
}