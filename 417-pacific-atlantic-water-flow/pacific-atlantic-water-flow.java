class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];

        List<List<Integer>> res = new ArrayList<>();

        int row = heights.length;
        int col = heights[0].length;

        for(int i = 0; i < row; i++){
            dfs(i, 0, pac, heights);
            dfs(i, col - 1, atl, heights);
        }

        for(int i = 0; i < col; i++){
            dfs(0, i, pac, heights);
            dfs(row - 1, i, atl, heights);
        }

        for(int i= 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, boolean[][] vis, int[][] heights){

        vis[i][j] = true;

        for(int[] dir : directions){

            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && heights[nr][nc] >= heights[i][j] && !vis[nr][nc]){
                dfs(nr, nc, vis, heights);
            }
        }
    }
}