class Solution {
    public int evalRPN(String[] tokens) {

        //if num, add to stack
        //if opp, pop last 2 nums, op and put back int stack

        Stack<Integer> st = new Stack<>();

        for(String t : tokens){

            if(!"+-/*".contains(t)){
                st.push(Integer.parseInt(t));
                continue;
            }

            int num2 = st.pop();
            int num1 = st.pop();

            st.push(operate(t, num1, num2));
        }

        return st.pop();
    }

    private int operate(String t, int num1, int num2){

        if(t.equals("+")) return num1 + num2;
        else if(t.equals("-")) return num1 - num2;
        else if(t.equals("*")) return num1 * num2;
        else if(t.equals("/")) return num1 / num2;

        return -1;
    }
}