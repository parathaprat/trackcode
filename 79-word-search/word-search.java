class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {

        boolean[][] visit = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                
                if(dfs(i, j, 0, visit, word, board)) return true;

            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int ind, boolean[][] visit, String word, char[][] board){

        if(ind >= word.length()) return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(ind) || visit[i][j]) return false;

        visit[i][j] = true;

        for(int[] dir : directions){
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(dfs(nr, nc, ind + 1, visit, word, board)) return true;
        }

        visit[i][j] = false;
        return false;
    }
}