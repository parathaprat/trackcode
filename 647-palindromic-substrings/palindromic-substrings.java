class Solution {
    public int countSubstrings(String s) {

        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            int odd = checkPal(i, i, s);
            int even = checkPal(i, i + 1, s);

            ans += odd + even;
        }

        return ans;
        
    }

    private int checkPal(int l, int r, String s){

        if(l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)) return 0;

        return 1 + checkPal(l - 1, r + 1, s);
    }
}