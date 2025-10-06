class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];

        if(board[row][col] == 'M') board[row][col] = 'X';
        else reveal(row, col, board);

        return board;
    }

    public void reveal(int i, int j, char[][] board){

        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'E') return;

        int neigh = 0;
        neigh = numberMines(i, j, board, neigh);

        if(neigh > 0){
            board[i][j] = (char)(neigh + '0');
        }
        else{
            board[i][j] = 'B';

            reveal(i + 1, j, board);
            reveal(i - 1, j, board);
            reveal(i, j + 1, board);
            reveal(i, j - 1, board);
            reveal(i + 1, j + 1, board);
            reveal(i - 1, j - 1, board);
            reveal(i + 1, j - 1, board);
            reveal(i - 1, j + 1, board);
        }
    }

    private int numberMines(int row, int col, char[][] board, int c){

       if(row - 1 >= 0 && board[row - 1][col] == 'M') c++;
       if(row + 1 < board.length && board[row + 1][col] == 'M') c++;
       if(col - 1 >= 0 && board[row][col - 1] == 'M') c++;
       if(col + 1 < board[row].length && board[row][col + 1] == 'M') c++;

       if(row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] == 'M') c++;
       if(row + 1 < board.length && col - 1 >= 0 && board[row + 1][col - 1] == 'M') c++;
       if(row - 1 >= 0 && col + 1 < board[row].length && board[row - 1][col + 1] == 'M') c++;
       if(row + 1 < board.length && col + 1 < board[row].length && board[row + 1][col + 1] == 'M') c++;
       return c;
    }
}