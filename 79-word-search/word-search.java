class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(dfs(i, j, 0, word, board, visited)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int in, String word, char[][] board, boolean[][] visited){

        if(in >= word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(in) != board[i][j]) return false;

        visited[i][j] = true;

        for(int[] dir : directions){
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(dfs(nr, nc, in + 1, word, board, visited)) return true;
        }

        visited[i][j] = false;
        return false;
    }
}