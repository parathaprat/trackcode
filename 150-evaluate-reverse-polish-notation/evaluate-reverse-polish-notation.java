class Solution {
    public int evalRPN(String[] tokens) {
        
        //reverse polish = postfix
        //num, num, operator
        //when op, pop2, perform op and replace all3 in stack

        Stack<Integer> st = new Stack<>();

        for(String t : tokens){

            if(!"*+/-".contains(t)){
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

        switch(t){
            case "+":
                return num1 + num2;
            case "*":
                return num1 * num2;
            case "-":
                return num1 - num2;
            case "/":
                return num1 / num2;
            default:
                break;
        }

        return -1;
    }
}