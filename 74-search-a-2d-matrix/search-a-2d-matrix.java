class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //binary search over entire matric

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while(left <= right){

            int mid = left + (right - left)/2;

            //value of element -> mid/cols = how many rows skipped; mid%cols = how deep into the current ro ware you
            if(matrix[mid/cols][mid%cols] == target){
                return true;
            }
            else if(matrix[mid/cols][mid%cols] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return false;
    }
}