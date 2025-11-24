class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {

        boolean[][] visit = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(i, j, board, word, visit, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, boolean[][] visit, int ind){

        if(ind >= word.length()) return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j] || board[i][j] != word.charAt(ind)) return false;


        visit[i][j] = true;

        for(int[] dir : directions){

            int nr = i + dir[0];
            int nc = j + dir[1];

            if(dfs(nr, nc, board, word, visit, ind + 1)) return true;
        }

        visit[i][j] = false;

        return false;

    }
}