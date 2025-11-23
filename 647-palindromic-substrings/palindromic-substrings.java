class Solution {
    public int countSubstrings(String s) {

        //from each letter, assume odd and even palindromic substrings

        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            int odd = checkPal(i, i, s);
            int even = checkPal(i, i + 1, s);

            ans += odd + even;
        }

        return ans;
    }

    private int checkPal(int left, int right, String s){

        if(left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) return 0;

        left--;
        right++;
        
        return 1 + checkPal(left, right, s);

    }  
}