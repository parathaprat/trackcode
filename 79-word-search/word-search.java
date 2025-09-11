class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(dfs(board, i, j, word, visited, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, boolean[][] visited, int ind){

        if(ind >= word.length()) return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(ind) || visited[i][j]) return false;

        visited[i][j] = true;

        boolean rest = dfs(board, i + 1, j, word, visited, ind + 1) ||
                        dfs(board, i - 1, j, word, visited, ind + 1) ||
                        dfs(board, i, j + 1, word, visited, ind + 1) ||
                        dfs(board, i, j - 1, word, visited, ind + 1);

        visited[i][j] = false;

        return rest;
    }
}