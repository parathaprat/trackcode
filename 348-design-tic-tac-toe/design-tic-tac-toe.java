class TicTacToe {

    int[] rowCount;
    int[] colCount;
    int diagCount;
    int antiDiagCount;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        rowCount = new int[n];
        colCount = new int[n];
        diagCount = 0;
        antiDiagCount = 0;
    }
    
    public int move(int row, int col, int player) {

        int add = player == 1 ? 1 : -1;

        rowCount[row] += add;
        colCount[col] += add;

        if(row == col) diagCount += add;
        if(row + col == n - 1) antiDiagCount += add;

        if(
            Math.abs(rowCount[row]) == n || 
            Math.abs(colCount[col]) == n ||
            Math.abs(diagCount) == n || 
            Math.abs(antiDiagCount) == n
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