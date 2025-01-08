class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        //sort array in decending order of no of units
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        //greedy problem
        int currVal = 0;
        int currBoxes = 0;

        //for each box
        for(int[] box : boxTypes){

            //if the number of boxes is less than capacity 
            if(box[0] <= truckSize){

                //take all of them
                currVal += box[0] * box[1];

                //subtract number from capacity
                truckSize -= box[0];

                if(truckSize == 0) break;

                continue;

            }

            //if not, fill up truck with those boxes 
            currVal += truckSize * box[1];
            break;

        }

        return currVal;
        
    }
}