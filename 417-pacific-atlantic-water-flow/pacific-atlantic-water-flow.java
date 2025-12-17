class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {0, - 1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();

        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];

        for(int i = 0; i < heights.length; i++){
            dfs(i, 0, pac, heights);
            dfs(i, heights[0].length - 1, atl, heights);
        }

        for(int j = 0; j < heights[0].length; j++){
            dfs(0, j, pac, heights);
            dfs(heights.length - 1, j, atl, heights);
        }

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){

                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, boolean[][] visit, int[][] heights){

        visit[i][j] = true;

        for(int[] dir : directions){
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length
                && !visit[nr][nc] && heights[nr][nc] >= heights[i][j]
            ){
                dfs(nr, nc, visit, heights);
            }
        }

        return;
    }
}