class Solution {

    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int c = 0; c < cols; c++){
            dfs(0, c, pac, heights);
            dfs(rows - 1, c, atl, heights);
        }

        for(int r = 0; r < rows; r++){
            dfs(r, 0, pac, heights);
            dfs(r, cols - 1, atl, heights);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pac[i][j] && atl[i][j]) res.add(Arrays.asList(i, j));
            }
        }

        return res;
    }

    public void dfs(int i , int j, boolean[][] visit, int[][] heights){

        visit[i][j] = true;

        for(int[] dir : directions){

            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && heights[nr][nc] >= heights[i][j] && !visit[nr][nc]){
                dfs(nr, nc, visit, heights);
            }
        }
    }
}