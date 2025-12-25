class Solution {

    int ans = 0;

    public int countSubstrings(String s) {

        for(int i = 0; i < s.length(); i++){
            checkPal(i, i, s);
            checkPal(i, i + 1, s);
        }

        return ans;
    }

    private void checkPal(int l, int r, String s){

        if(l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)) return;

        ans++;

        checkPal(l - 1, r + 1, s);
    }
}