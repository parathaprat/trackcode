class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(dfs(0, i, j, board, visited, word)) return true;
            }
        }

        return false;
        
    }

    private boolean dfs(int ind, int i, int j, char[][] board, boolean[][] visited, String word){

        if(ind >= word.length()) return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(ind) || visited[i][j]) return false;

        visited[i][j] = true;

        boolean rest =  dfs(ind + 1, i, j + 1, board, visited, word) || 
        dfs(ind + 1, i + 1, j, board, visited, word) || 
        dfs(ind + 1, i - 1, j, board, visited, word) || 
        dfs(ind + 1, i, j - 1, board, visited, word);

        visited[i][j] = false;

        return rest;
    }
}