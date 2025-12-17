class Solution {

    int fresh = 0;
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

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

            int size = q.size();

            for(int i = 0; i < size; i++){

                int[] or = q.poll();

                for(int[] dir : directions){

                    int nr = or[0] + dir[0];
                    int nc = or[1] + dir[1];

                    addOrange(nr, nc, grid, q);
                }
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
    }
}