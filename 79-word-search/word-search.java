class Solution {
    public boolean exist(char[][] board, String word) {

    //brute force recurive backtracking

    //go through each position, dfs on it

    boolean[][] visit = new boolean[board.length][board[0].length];

    for(int i = 0; i < board.length; i++){

        for(int j = 0; j < board[0].length; j++){

            if(dfs(board, i, j, visit, word, 0)) return true;
        }
    }

    return false;
        
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] visit, String word, int ind){

        //base case
        if(ind == word.length()) return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(ind) || visit[i][j]) return false;

        visit[i][j] = true;

        boolean res = dfs(board, i + 1, j, visit, word, ind + 1) ||
                      dfs(board, i - 1, j, visit, word, ind + 1) ||
                      dfs(board, i, j + 1, visit, word, ind + 1) ||
                      dfs(board, i, j - 1, visit, word, ind + 1);

        visit[i][j] = false;

        return res;

    }
}