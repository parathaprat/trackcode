class Solution {
    public int orangesRotting(int[][] grid) {
        
        //BFS trav, level wise
        //time++ at each level

        //add rotting oranges to queue
        //maintain a fresh count
        //keep running until q is empty or fresh == 0

        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 2) q.add(new int[]{i , j});
                if(grid[i][j] == 1) fresh++;

            }
        }

        int time = 0;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while(!q.isEmpty() && fresh != 0){

            int level = q.size();

            for(int i = 0; i < level; i++){

                int[] orange = q.poll();

                for(int[] dir : directions){
                    
                    int nr = orange[0] + dir[0];
                    int nc = orange[1] + dir[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr, nc});
                    }
                    
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}