class Solution {
    public boolean isPalindrome(String s) {

        String ans = "";

        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                ans += c;
            }
        }

        ans = ans.toLowerCase();

        int r = ans.length() - 1;
        int l = 0;

        while(l <= r){
            if(ans.charAt(l) != ans.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
        
    }
}