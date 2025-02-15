class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        

        int[] ans = new int[2];
        int rowOne = 0;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){

                if(mat[i][j] == 1) rowOne++;
            }

            if(rowOne > ans[1]){
                ans[0] = i;
                ans[1] = rowOne;
            }

            rowOne = 0;
        }

        return ans;
    }
}