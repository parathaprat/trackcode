class Solution {
    public int countBinarySubstrings(String s) {

        int curGroupLen = 1;
        int prevGroupLen = 0;
        int count = 0;

        for(int i = 1; i < s.length(); i++){

            if(s.charAt(i) == s.charAt(i - 1)) curGroupLen++;
            else{

                count += Math.min(prevGroupLen, curGroupLen);

                prevGroupLen = curGroupLen;
                curGroupLen = 1;
            }
        }

        count += Math.min(curGroupLen, prevGroupLen);
        return count;
        
    }
}