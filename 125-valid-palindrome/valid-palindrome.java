class Solution {
    public boolean isPalindrome(String s) {
        
        String ans = "";

        //iterate thru each char, add only if it is digit or letter
        for(char c : s.toCharArray()){

            if(Character.isDigit(c) || Character.isLetter(c)){
                ans += c;
            }

        }

        ans = ans.toLowerCase();

        int left = 0;
        int right = ans.length() - 1;

        while(left <= right){

            if(ans.charAt(left) != ans.charAt(right)) return false;

            left++;
            right--;
        }

        return true;

    }
}