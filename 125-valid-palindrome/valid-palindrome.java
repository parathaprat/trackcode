class Solution {
    public boolean isPalindrome(String s) {
        
        String ans = "";

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch) || Character.isLetter(ch)){
                ans += ch;
            }
        }

        ans = ans.toLowerCase();

        int right = ans.length() - 1;
        int left = 0;

        while(left <= right){
            if(ans.charAt(left) != ans.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}