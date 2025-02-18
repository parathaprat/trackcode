public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int res = 0;
        boolean isSigned = false;

        if(n < 0){
            isSigned = true;
        }

        int val = 31;

        while(val --> 0){

            //AND n with 1, OR with res; right shift n, right shift res
            res|= (n & 1);
            n = n >> 1;
            res = res << 1;

        }

        //if signed, return res + 1;
        return isSigned ? res + 1 : res;
    }
}