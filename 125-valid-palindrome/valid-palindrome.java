class Solution {
    public boolean isPalindrome(String s) {

        String check = "";

        for(char c : s.toCharArray()){

            if(Character.isDigit(c) || Character.isLetter(c)){
                check += c;
            }
        }

        check = check.toLowerCase();

        int left = 0;
        int right = check.length() - 1;

        while(left <= right){

            if(check.charAt(left) != check.charAt(right)) return false;
            left++;
            right--;
        }

        return true;

        
    }
}