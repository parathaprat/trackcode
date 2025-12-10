class Solution {
    public boolean isPalindrome(String s) {

        String str = "";

        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)) str += c;
        }

        str = str.toLowerCase();

        int l = 0;
        int r = str.length() - 1;

        while(l < r){

            if(str.charAt(l) != str.charAt(r)) return false;

            l++;
            r--;
        }

        return true;
    }
}