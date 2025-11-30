class Solution {

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {

        Map<Integer, Integer> areaMap = new HashMap<>(); //islandID -> area
        int id = 2;
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 1){
                    int curArea = dfs(i, j, grid, id);
                    areaMap.put(id, curArea);
                    maxArea = Math.max(curArea, maxArea);
                    id++;
                } 
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 0){

                    Set<Integer> seen = new HashSet<>();
                    int newArea = 1;

                    for(int[] d : directions){
                        int r = i + d[0];
                        int c = j + d[1];

                        //if a existing island is adjacent, add that area
                        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] > 1){
                            int islandId = grid[r][c];
                            if(seen.add(islandId)){
                                newArea += areaMap.get(islandId);
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid, int id){

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return 0;

        grid[i][j] = id;

        return 1 +
            dfs(i + 1, j, grid, id) +
            dfs(i - 1, j, grid, id) +
            dfs(i, j + 1, grid, id) +
            dfs(i, j - 1, grid, id);
    }
}