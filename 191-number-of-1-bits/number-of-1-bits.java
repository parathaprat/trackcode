class Solution {
    public int hammingWeight(int n) {
        
        //perform AND with num - 1 until num != 0

        int count = 0;
        
        while(n != 0){

            n = n & (n - 1);
            count++;

        }

        return count;
    }
}