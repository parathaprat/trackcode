class Solution {

    int max = 0;
    int leftp = 0;
    int rightp = 0;

    public String longestPalindrome(String s) {
        
        for(int i = 0; i < s.length() - 1; i++){

            checkPal(i, i, s);
            checkPal(i, i + 1, s);
        }

        return s.substring(leftp, rightp + 1);
    }

    private void checkPal(int left, int right, String s){

        if(left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) return;

        if(max < right - left + 1){
            max = right - left + 1;
            leftp = left;
            rightp = right;
        }

        left--;
        right++;
        
        checkPal(left, right, s);
    }
}