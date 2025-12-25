class Solution {

    int l = 0;
    int r = 0;
    int len = 0;

    public String longestPalindrome(String s) {

        for(int i = 0; i < s.length(); i++){
            checkPal(i, i, s);
            checkPal(i, i + 1, s);
        }

        return s.substring(l, r + 1);
    }

    private void checkPal(int left, int right, String s){

        if(left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) return;

        if(len < right - left + 1){
            len = right - left + 1;
            l = left;
            r = right;
        }

        checkPal(left - 1, right + 1, s);
    }
}