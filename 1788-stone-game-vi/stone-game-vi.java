class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        
        //create 2d array to store sum, alice, bob values
        int[][] v = new int[aliceValues.length][3];

        for(int i = 0; i < aliceValues.length; i++){
           v[i][0] = aliceValues[i] + bobValues[i];
           v[i][1] = aliceValues[i];
           v[i][2] = bobValues[i];
        }

        //sort them by decending order of sum, if equal use alice vals
        Arrays.sort(v, (a, b) -> {
            if(b[0] != a[0]){
                return b[0] - a[0];
            }
            else{
                return b[1] - a[1];
            }
        });

        //final sum variables for both and calcualte final sum for each
        int a = 0;
        int b = 0;
        for(int i = 0; i < aliceValues.length; i++){
            
            //each even turn is A and each odd turn is B
            if(i % 2 == 0){
                a += v[i][1];
            }
            else{
                b += v[i][2];
            }
        }

        //final ans based on scores
        if(a == b){
            return 0;
        }
        else if(a > b){
            return 1;
        }
        else return -1;

    }
}