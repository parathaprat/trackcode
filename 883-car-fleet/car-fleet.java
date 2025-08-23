class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        //Sort accroding to position in [position, speed]
        //higher position first since we want to iterate from the back
        //Create stack, add and merge according to time

        //[position][speed]
        int[][] cars = new int[position.length][2];

        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        //sorting in descending order of position
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        //use double to handle decimals
        Stack<Double> st = new Stack<>();

        //calculate times of arrival and merge
        for(int[] car : cars){
            int pos = car[0];
            int spd = car[1];

            double time = (double)(target - pos) / spd;

            if(st.isEmpty() || time > st.peek()){
                st.push(time);
            }
        }

        return st.size();
    }
}