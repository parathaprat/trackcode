class Solution {

    int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public boolean exist(char[][] board, String word) {

        boolean[][] visit = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(dfs(i, j, board, 0, word, visit)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, char[][] board, int ind, String word, boolean[][] visit){

        if(ind >= word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j] || word.charAt(ind) != board[i][j]) return false;

        visit[i][j] = true;

        for(int[] dir : directions){
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(dfs(nr, nc, board, ind + 1, word, visit)) return true;;
        }

        visit[i][j] = false;
        return false;
    }
}