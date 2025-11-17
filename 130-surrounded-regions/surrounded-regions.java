class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {

        int r = board.length;
        int c = board[0].length;

        for(int i = 0; i < r; i++){
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][c - 1] == 'O') dfs(i, c - 1, board);
        }

        for(int i = 0; i < c; i++){
            if(board[0][i] == 'O') dfs(0, i, board);
            if(board[r - 1][i] == 'O') dfs(r - 1, i, board);
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }

        return;
    }

    private void dfs(int i, int j, char[][] board){

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;

        board[i][j] = 'T';

        for(int[] dir : directions){

            dfs(i + dir[0], j + dir[1], board);
        }

        return;
    }
}