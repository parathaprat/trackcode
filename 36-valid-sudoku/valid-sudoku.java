class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //use a hashset and encode when numbers are present along with row, col, block
        //row -> number + "row" + i
        //col -> number + "col" + j
        //block -> number + "block" + i/3 + "," + j/3

        Set set = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                //skip if no number present
                if(board[i][j] == '.') continue;

                if(
                    !set.add(board[i][j] + "row" + i) ||
                    !set.add(board[i][j] + "col" + j) ||
                    !set.add(board[i][j] + "block" + i/3 + "," + j/3)
                )
                return false;
            }
        }

        return true;
    }
}