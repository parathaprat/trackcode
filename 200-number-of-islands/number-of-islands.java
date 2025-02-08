class Solution {

    int count = 0;

    public int numIslands(char[][] grid) {

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == '1'){
                    count++;
                    countLand(grid, i, j);
                }
            }
        }

        return count;
        
    }

    private void countLand(char[][] grid, int i, int j){

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';

        
            countLand(grid, i + 1, j);
            countLand(grid, i - 1, j);
            countLand(grid, i, j + 1);
            countLand(grid, i, j - 1);
     
    }
}