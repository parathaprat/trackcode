class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0;
        int c = cols-1;

        while(r < rows && c >= 0){
            int val = matrix[r][c];

            if(val == target) return true;
            else if(val > target) c--;
            else r++;
        }

        return false;
        
    }
}