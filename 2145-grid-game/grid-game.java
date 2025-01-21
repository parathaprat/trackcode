class Solution {
    public long gridGame(int[][] grid) {
        
        //define topSum and bottomSum, update ans 

        long topSum = 0;

        int n = grid[0].length;

        //loop calculating top sum
        for(int i = 0; i < n; i++){

            topSum += grid[0][i];

        }

        long bottomSum = 0;
        long ans = Long.MAX_VALUE;

        for(int k = 0; k < n; k++){

            //subtract topSum
            topSum -= grid[0][k];

            //update ans
            ans = Math.min(ans, Math.max(topSum, bottomSum));

            //update bottom sum
            bottomSum += grid[1][k];
        }

        return ans;

    }
}