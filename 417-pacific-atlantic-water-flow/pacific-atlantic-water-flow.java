class Solution {

    //direction array
    int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        //dfs search
        int rows = heights.length;
        int cols = heights[0].length;

        //visited boolean arrays for both
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        //base -> top row will touch pacific, bottom row will touch atlantic
        for(int c = 0; c < cols; c++){

            dfs(0, c, pac, heights);
            dfs(rows - 1, c, atl, heights);

        }   

        //base -> left col will touch pacific, right col will touch atlantic
        for(int r = 0; r < rows; r++){

            dfs(r, 0, pac, heights);
            dfs(r, cols - 1, atl, heights);

        }

        List<List<Integer>> res = new ArrayList<>();

        //add coordinates to result array if it can reach both oceans
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){

                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    public void dfs(int r, int c, boolean[][] visited, int[][] heights){

        visited[r][c] = true;

        for(int[] dir : direction){

            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && heights[nr][nc] >= heights[r][c] && !visited[nr][nc]){
                dfs(nr, nc, visited, heights);
            }
        }

        
    }
}