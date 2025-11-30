class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        //Stack
        //st.peek +ve, incoming -ve
        //-ve > +ve : st.pop, add -ve
        //+ve > -ve : nothing, do not add -ve
        //+ve == -ve : pop and do not add -ve
        //use boolean to add -ve

        Stack<Integer> st = new Stack<>();

        for(int a : asteroids){

            boolean isAlive = true;

            while(!st.isEmpty() && st.peek() > 0 && a < 0){

                if(st.peek() < -a){
                    st.pop();
                }
                else if(st.peek() == -a){
                    st.pop();
                    isAlive = false;
                    break;
                }
                else{
                    isAlive = false;
                    break;
                }
            }

            if(isAlive) st.add(a);
        }

        int[] res = new int[st.size()];
        
        for(int i = 0; i < st.size(); i++){
            res[i] = st.get(i);
        }

        return res;
    }
}