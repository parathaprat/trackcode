class Solution {

    int fresh = 0;

    public int orangesRotting(int[][] grid) {

        //multi BFS with fresh count

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

                int[] coord = q.poll();

                addOrange(coord[0] + 1, coord[1], grid, q);
                addOrange(coord[0] - 1, coord[1], grid, q);
                addOrange(coord[0], coord[1] + 1, grid, q);
                addOrange(coord[0], coord[1] - 1, grid, q);

            }

            time++;
        }

        return fresh == 0 ? time : -1;
        
    }

    private void addOrange(int x, int y, int[][] grid, Queue<int[]> q){

        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) return;

        grid[x][y] = 2;
        fresh--;

        q.add(new int[]{x, y});

        return;
    }
}