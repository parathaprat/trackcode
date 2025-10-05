class Solution {

    //we check for odd and even palindroms at each character

    int ans = 0;

    public int countSubstrings(String s) {
        
        for(int i = 0; i < s.length(); i++){

            checkPal(i, i, s);
            checkPal(i, i + 1, s);

        }
        
        return ans;
    }

    private void checkPal(int start, int end, String s){

        if(s == null || start > end) return;

        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            ans++;
            start--;
            end++;
        }
    }
}