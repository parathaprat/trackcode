class Solution {

    int ans = 0;

    public int countSubstrings(String s) {

        for(int i = 0; i < s.length(); i++){
            checkPal(i, i, s);
            checkPal(i, i + 1, s);
        }

        return ans;
    }

    private void checkPal(int left, int right, String s){

        if(left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) return;

        ans++;

        checkPal(left - 1, right + 1, s);
    }
}