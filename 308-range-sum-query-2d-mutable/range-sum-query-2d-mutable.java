class NumMatrix {

    int[][] matrix;
    int[][] original;

    public NumMatrix(int[][] matrix) {

        original = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                original[i][j] = matrix[i][j];
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] += matrix[i - 1][j];
            }
        }

        this.matrix = matrix;
        
    }
    
    public void update(int row, int col, int val) {

        int delta = val - original[row][col];
        original[row][col] = val;

        for(int i = row; i < matrix.length; i++){
            for(int j = col; j < matrix[0].length; j++){
                matrix[i][j] += delta;
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        //total - extra

        int total = matrix[row2][col2];

        int extra = (row1 != 0 ? matrix[row1 - 1][col2] : 0) + 
                    (col1 != 0 ? matrix[row2][col1 - 1] : 0) -
                    (row1 != 0 && col1 != 0 ? matrix[row1 - 1][col1 - 1] : 0);

        return total - extra;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */