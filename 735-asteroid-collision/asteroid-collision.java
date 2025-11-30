class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for(int a : asteroids){

            boolean alive = true;

            while(!st.isEmpty() && st.peek() > 0 && a < 0){

                int top = st.peek();

                if(top < -a){
                    st.pop(); //incoming -ve is larger, pop current +ve
                } 
                else if(top == -a){ //incoming -ve == current +ve
                    st.pop();
                    alive = false;
                    break;
                }
                else{ //+ve larger than incoming -ve
                    alive = false;
                    break;
                }
            }

            if(alive) st.push(a);
        }

        int[] res = new int[st.size()];

        for(int i = 0; i < res.length; i++){
            res[i] = st.get(i);
        }

        return res;
    }
}