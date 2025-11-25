class Solution {
    public int countSubstrings(String s) {

        int ans = 0;

        for(int i = 0; i < s.length(); i++){

            int oddPal = checkPal(i, i, s);
            int evenPal = checkPal(i, i + 1, s);

            ans += oddPal + evenPal;
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