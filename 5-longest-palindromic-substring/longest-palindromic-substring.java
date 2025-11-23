class Solution {

    int left = 0;
    int right = 0;
    int ans = 0;

    public String longestPalindrome(String s) {

        //at each index, assume odd len and even len palindromes
        //explore all pals and keep track of the longest length

        for(int i = 0; i < s.length() - 1; i++){
            checkPal(i, i, s);
            checkPal(i, i + 1, s);
        }  

        return s.substring(left, right + 1); 

        
        
    }

    private void checkPal(int leftp, int rightp, String s){

        if(leftp < 0 || rightp >= s.length() || s.charAt(leftp) != s.charAt(rightp)) return;

        //if longer pal found, update index
        if(ans < rightp - leftp + 1){

            ans = rightp - leftp + 1;

            left = leftp;
            right = rightp;

        }

        leftp--;
        rightp++;

        checkPal(leftp, rightp, s);
    }
}