class Solution {
    public boolean isPalindrome(int x) {
        
        int reverse = 0;
        int num = x;

        if(x < 0){
            return false;
        }

        while(num != 0){
            reverse = reverse * 10;
            reverse = reverse + num % 10;

            num = num/10;
        }

        if(x == reverse){
            return true;
        }

        return false;
    }
}