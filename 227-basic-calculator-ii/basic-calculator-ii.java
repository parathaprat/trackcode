class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();
        char prevOperator = '+';
        int num = 0;

        for(int i = 0; i <= s.length(); i++){

            //\0 is a null
            char ch = i < s.length() ? s.charAt(i) : '\0';

            if(Character.isDigit(ch)){

                //char is a digit, so - '0';
                num = num * 10 + ch - '0';
            }

            if(!Character.isDigit(ch) && ch != ' ' || i == s.length()){

                if(prevOperator == '+') stack.push(num);
                if(prevOperator == '-') stack.push(-num);
                if(prevOperator == '*') stack.push(stack.pop() * num);
                if(prevOperator == '/') stack.push(stack.pop() / num);

                //update prev op since ch is not a digit// update num since it is now processed
                prevOperator = ch;
                num = 0;
            }

        }

        int result = 0;

        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;

        
    }
}