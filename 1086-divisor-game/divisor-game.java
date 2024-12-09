class Solution {
    public boolean divisorGame(int n) {
        
        //main logic -> if n is even, alice wins or bob wins
        return n % 2 == 0 ? true : false;

    }
}