class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int[][] cars = new int[speed.length][2];

        for(int i = 0; i < speed.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> st = new Stack<>();

        for(int[] car : cars){
            
            double time = (double)(target - car[0])/car[1];

            if(st.isEmpty() || time > st.peek()){
                st.push(time);
            }
        }

        return st.size();
    }
}