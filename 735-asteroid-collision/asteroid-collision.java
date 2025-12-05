class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for(int num : asteroids){

            boolean alive = true;

            while(alive && num < 0 && !st.isEmpty() && st.peek() > 0){

                int top = st.peek();

                if(top > -num){
                    alive = false;
                    break;
                }
                else if(top < -num){
                    st.pop();
                }
                else if(top == -num){
                    st.pop();
                    alive = false;
                    break;
                }
            }

            if(alive) st.add(num);
        }

        int[] res = new int[st.size()];

        for(int i = 0; i < st.size(); i++){
            res[i] = st.get(i);
        }

        return res;
        
    }
}