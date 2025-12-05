class TicTacToe {

    //maintain arrays for row count, col count, diag count and antidiag count

    int[] rowCount;
    int[] colCount;
    int diag;
    int antiDiag;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        rowCount = new int[n];
        colCount = new int[n];
        diag = 0;
        antiDiag = 0;
    }
    
    public int move(int row, int col, int player) {
        
        int add = player == 1 ? 1 : -1;

        rowCount[row] += add;
        colCount[col] += add;
        if(row == col) diag += add;
        if(row + col == n - 1) antiDiag += add;

        if(
            Math.abs(rowCount[row]) == n || 
            Math.abs(colCount[col]) == n ||
            Math.abs(diag) == n ||
            Math.abs(antiDiag) == n
        ){
            return player;
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */