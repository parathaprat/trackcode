class Solution {

    //use a BFS algorithm, with a min heap priority queue on the State class, sorted by 'removed'

    //start by creating a directions array

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //declate a new class, with R, C and removals
    class State{
        int rows;
        int cols;
        int removals;

        State(int rows, int cols, int removals){
            this.rows = rows;
            this.cols = cols;
            this.removals = removals;
        }
    }


    public int minimumObstacles(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        //create priority q with lambda functiont to sort by removals
        Queue<State> pq = new PriorityQueue<>((a, b) -> a.removals - b.removals);

        //add first block, create boolean visited array, visited first block
        pq.add(new State(0, 0, 0));

        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        //start BFS
        while(!pq.isEmpty()){

            State block = pq.poll();

            //take block and check if it is the final block (rows - 1, cols - 1)
            if(block.rows == rows - 1 && block.cols == cols - 1){
                return block.removals;
            }

            for(int[] dir : dirs){

                int nextRow = block.rows + dir[0];
                int nextCol = block.cols + dir[1];

                //check if block is valid (R,C < 0; R,C >= grid; visited[R][C])
                if(nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols|| visited[nextRow][nextCol]){
                    continue;
                }

                //if valid, visit block
                State blockTuah = new State(nextRow, nextCol, block.removals);
                visited[nextRow][nextCol] = true;

                //if new block is an obstacle (removals = 1), ++ and add to pq
                if(grid[nextRow][nextCol] == 1){
                    blockTuah.removals++;
                }

                pq.add(blockTuah);

            }
        }

        return -1;

    }
}