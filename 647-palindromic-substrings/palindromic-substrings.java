class Solution {

    int ans = 0;

    public int countSubstrings(String s) {

        //odd palindrome: 1 char center
        //even palindrome: 2 char center

        //go through each char, check for odd and even palindroms, ret ans

        for(int i = 0; i < s.length(); i++){
            checkPal(i, i, s);
            checkPal(i, i + 1, s);
        }

        return ans;        
    }

    private void checkPal(int start, int end, String s){

        // if(s == null || start > end) return;

        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end) && s != null && start <= end){
            ans++;
            start--;
            end++;
        }

        return;



        
    }
}