class Solution {
    public int countBinarySubstrings(String s) {

        int prevGroupLen = 0;
        int curGroupLen = 1;
        int count = 0;

        for(int i = 1; i < s.length(); i++){

            if(s.charAt(i) == s.charAt(i - 1)) curGroupLen++;
            else{

                count += Math.min(prevGroupLen, curGroupLen);

                prevGroupLen = curGroupLen; //shift
                curGroupLen = 1; //reset
            }
        }

        count += Math.min(prevGroupLen, curGroupLen); //add last pair
        return count;
    }
}