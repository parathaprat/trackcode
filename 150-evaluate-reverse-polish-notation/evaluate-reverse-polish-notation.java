class Solution {
    public int evalRPN(String[] tokens) {
        
        //reverse polish -> postfix
        //everytime we hit a operator, we use it on prev 2 numbers and replace all 3 with res

        Stack<Integer> st = new Stack<>();

        for(String t : tokens){

            if(!"+/*-".contains(t)){
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

        int res = 0;

        switch(t){

            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
            default:
                break;
            
        }

        return res;
    }
}