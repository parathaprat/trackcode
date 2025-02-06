class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;

        //go through each unit and ++ count and call BFS if land occurs
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == '1'){
                    count++;
                    BFS(i, j, grid);
                }

            }
        }

        return count;
    }

    //main logic
    public void BFS(int i, int j, char[][] grid){

        //bounds, and if i,j = 0
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;

        //mark land as water
        grid[i][j] = '0';

        BFS(i + 1, j, grid);
        BFS(i - 1, j, grid);
        BFS(i, j + 1, grid);
        BFS(i, j - 1, grid);
    }
}