class Solution {

    public boolean exist(char[][] board, String word) {
        
        //optimal -> brute force
        boolean[][] visit = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(dfs(board, i, j, 0, word, visit)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int ind, String word, boolean[][] visit){

        if(ind == word.length()) return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(ind) || visit[i][j]) return false;

        visit[i][j] = true;

        boolean rest = dfs(board, i + 1, j, ind + 1, word, visit) ||
                       dfs(board, i - 1, j, ind + 1, word, visit) ||
                       dfs(board, i, j + 1, ind + 1, word, visit) ||
                       dfs(board, i, j - 1, ind + 1, word, visit);

        visit[i][j] = false;

        return rest;
    }
}