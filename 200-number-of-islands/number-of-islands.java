class Solution {
    public int numIslands(char[][] grid) {
        
        int ans = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == '1'){
                    ans++;
                    countLand(grid, i, j);
                }
            }
        }

        return ans;
    }

    public void countLand(char[][] grid, int i, int j){

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        countLand(grid, i + 1, j);
        countLand(grid, i - 1, j);
        countLand(grid, i, j + 1);
        countLand(grid, i, j - 1);
    }
}