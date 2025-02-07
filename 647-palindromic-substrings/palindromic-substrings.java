class Solution {

    int ans = 0;

    public int countSubstrings(String s) {

        if(s == null) return 0;
        
        for(int i = 0; i < s.length(); i++){

            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i + 1);
        }

        return ans;
    }

    public void checkPalindrome(String s, int left, int right){

        if(s == null || left > right) return;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            ans++;
            left--;
            right++;
        }

    } 
}