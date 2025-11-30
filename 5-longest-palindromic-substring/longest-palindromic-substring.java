class Solution {

    int left = 0;
    int right = 0;
    int max = 0;

    public String longestPalindrome(String s) {

        for(int i = 1; i < s.length(); i++){
            checkPal(i, i, s);
            checkPal(i, i - 1, s);
        }

        return s.substring(left, right + 1);
    }

    private void checkPal(int l, int r, String s){

        if(l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)) return;

        if(r - l + 1 > max){
            max = r - l + 1;
            left = l;
            right = r;
        }

        checkPal(l - 1, r + 1, s);
    }
}