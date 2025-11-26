class NumMatrix {

    int[][] matrix;
    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {

        this.matrix = matrix;
        prefixSum = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                prefixSum[i][j] = matrix[i][j];
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }
        
    }
    
    public void update(int row, int col, int val) {

        int delta = val - matrix[row][col];
        matrix[row][col] = val;

        for(int i = row; i < matrix.length; i++){
            for(int j = col; j < matrix[0].length; j++){
                prefixSum[i][j] += delta;
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        int total = prefixSum[row2][col2];

        int extra = (row1 > 0 ? prefixSum[row1 - 1][col2] : 0) +
                    (col1 > 0 ? prefixSum[row2][col1 - 1] : 0) -
                    (row1 > 0 && col1 > 0 ? prefixSum[row1 - 1][col1 - 1] : 0);

        return total - extra;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */