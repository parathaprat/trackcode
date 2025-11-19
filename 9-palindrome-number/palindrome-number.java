class Solution {
    public boolean isPalindrome(int x) {

        //-ve, numbers ending in 0 cannot be palindroms
        //reverse hald the list, return true accordingly 

        if(x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reverse = 0;

        while(x > reverse){
            reverse = reverse * 10 + x%10;
            x /= 10;
        }

        return x == reverse || x == reverse/10;
        
    }
}