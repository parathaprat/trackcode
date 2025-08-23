class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //flatten it out and do binary search
        int r = matrix.length;
        int c = matrix[0].length;

        int l = 0;
        int ri = r * c - 1;

        while(l <= ri){

            int m = l + (ri - l)/2;

            if(matrix[m/c][m%c] == target){
                return true;
            }
            else if(matrix[m/c][m%c] < target){
                l = m + 1;
            }
            else{
                ri = m - 1;
            }
        }

        return false;
    }
}