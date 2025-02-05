class Solution {
    public int getSum(int a, int b) {
        
        //main logic -> a XOR b; a & b << 1;
        //a handles addition (XOR)
        //b handles AND and << 1 
        while(b != 0){

            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;

        }

        return a;
    }
}