class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        //using hashmap to track (cellState, day)
        Map<String, Integer> map = new HashMap<>();

        //convert cells array to a string to store in hashMap
        String cellsStr = Arrays.toString(cells);

        //for each of the n days
        for(int i = 0; i < n; i++){

            //adding state of cells and and that day i to map 
            map.put(cellsStr, i);

            //calcuclate next state 
            cells = nextDay(cells);
            cellsStr = Arrays.toString(cells);

            if(map.containsKey(cellsStr)){

                //length of cycle
                int daysAgo = i + 1 - map.get(cellsStr);

                //no of days left to simulate -> we need to simulate only for daysLeft % daysAgo cycles
                int daysLeft = n - (i + 1);

                return doLastNDays(cells, daysLeft % daysAgo);
            }


        }

        //if cycel isn't obtained, for loop completes and return ans
        return cells;
    }

    //call nextDay(cells) daysLeft % daysAgo times
    int[] doLastNDays(int[] cells, int n){

        for(int i = 0; i < n; i++){
            cells = nextDay(cells);
        }

        return cells;
    }

    //func to calculate state of cells ont he next day
    int[] nextDay(int[] cells){

        int[] newCells = new int[8];

        //loop through cells, skip 1st and last ind
        for(int i = 1; i < cells.length - 1; i++){

            //if adj cells ==, set newCell[i] to 1
            if(cells[i - 1] == cells[i + 1]){
                newCells[i] = 1;
            } 
            else{
                newCells[i] = 0;
            }
        }

        return newCells;
    }
}