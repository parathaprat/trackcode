class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //create a set (string) to store row, col and block postions
        //row = number + "row" + i;
        //col = number + "col" + j;
        //block = number + "block" + i/3 + j/3;

        Set<String> set = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(board[i][j] != '.'){

                    if(
                        !set.add(board[i][j] + "row" + i) ||
                        !set.add(board[i][j] + "col" + j) ||
                        !set.add(board[i][j] + "block" + i/3 + j/3)
                    )
                    return false;
                }
            }
        }

        return true;
    }
}