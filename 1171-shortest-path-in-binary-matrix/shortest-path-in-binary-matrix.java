class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {0, - 1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length -1] != 0) return -1;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[grid.length][grid[0].length];

        q.add(new int[]{0, 0});
        visit[0][0] = true;

        int path = 1;
        
        while(!q.isEmpty()){

            int level = q.size();

            for(int i = 0; i < level; i++){

                int[] rc = q.poll();
                int row = rc[0];
                int col = rc[1];

                if(row == grid.length - 1 && col == grid[0].length - 1) return path;

                for(int[] dir : directions){
                    
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || visit[nr][nc] || grid[nr][nc] != 0) continue;

                    q.add(new int[]{nr, nc});
                    visit[nr][nc] = true;


                }
            }

            path++;
        }

        return -1;
        
    }
}