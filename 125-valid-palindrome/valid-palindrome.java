class Solution {
    public boolean isPalindrome(String s) {
        
        String ans = "";

        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                ans += c;
            }
        }

        ans = ans.toLowerCase();

        int right = ans.length() - 1;
        int left = 0;

        while(left <= right){
            if(ans.charAt(right) != ans.charAt(left)) return false;
            left++;
            right--;
        }

        return true;
    }
}