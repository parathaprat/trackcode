class Solution {
    public void setZeroes(int[][] matrix) {

        //use 1st col and 1st row to store 0 index's for its corresponding r/c
        //store the one overlapping index seperately

        boolean firstColZero = false;

        for(int i = 0; i < matrix.length; i++){

            if(matrix[i][0] == 0) firstColZero = true;

            for(int j = 1; j < matrix[0].length; j++){

                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //use those zeros to convert rows and cols into 0s

        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j > 0; j--){

                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }

            if(firstColZero) matrix[i][0] = 0;
        }
    }
}