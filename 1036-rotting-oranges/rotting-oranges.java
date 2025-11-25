class Solution {

    int fresh = 0;

    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        int time = 0;

        while(!q.isEmpty() && fresh != 0){

            int level = q.size();

            for(int i = 0; i < level; i++){

                int[] rc = q.poll();

                int row = rc[0];
                int col = rc[1];

                addOrange(row + 1, col, grid, q);
                addOrange(row - 1, col, grid, q);
                addOrange(row, col + 1, grid, q);
                addOrange(row, col - 1, grid, q);
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }

    private void addOrange(int i, int j, int[][] grid, Queue<int[]> q){

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;

        grid[i][j] = 2;
        fresh--;
        q.add(new int[]{i, j});
        return;
    }
}