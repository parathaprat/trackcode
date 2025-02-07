class Solution {
    public String longestPalindrome(String s) {

        //base case
        if(s.length() == 0) return null;
        
        //define start and end of substring
        int start = 0;
        int end = 0;

        //expand from each char as a potencial palindrome
        for(int i = 0; i < s.length(); i++){

            //pal may be odd or even
            //odd -> middle is one element
            int oddPal = longPal(s, i, i);

            //even -> middle is 2 elements
            int evenPal = longPal(s, i, i + 1);

            //get the max of both, calculate start and end, and return substring
            int finalLen = Math.max(oddPal, evenPal);

            //if finalPal > current pal, update start and end
            if(finalLen > end - start){

                start = i - (finalLen - 1)/2;
                end = i + finalLen/2;

            }

        }

        return s.substring(start, end + 1);

    }

    private int longPal(String s, int left, int right){

            //base 
            if(s == null || left > right) return 0;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }

            return right - left - 1;


        }
}