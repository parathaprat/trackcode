class Solution {
    public int[] countBits(int n) {

        int[] ans = new int[n + 1];

        ans[0] = 0;
        
        for(int i = 1; i <= n; i++){

            int num = i;
            int count = 0;

            while(num != 0){
                num = num & (num - 1);
                count++;
            }

            ans[i] = count;
            
        }

        return ans;
    }
}