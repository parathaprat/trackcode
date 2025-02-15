class Solution {
    public int calculate(String s) {

        int num = 0;
        char prevOperator = '+';

        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i <= s.length(); i++){

            char ch = i < s.length() ? s.charAt(i) : '\0';

            if(Character.isDigit(ch)){

                num = num * 10 + (ch - '0');

            }

            if(!Character.isDigit(ch) && ch != ' ' || i == s.length()){

                if(prevOperator == '+') st.push(num);
                if(prevOperator == '-') st.push(-num);
                if(prevOperator == '*') st.push(st.pop() * num);
                if(prevOperator == '/') st.push(st.pop() / num);

                prevOperator = ch;
                num = 0;
            }

        }

        int result = 0;

        while(!st.isEmpty()){

            result += st.pop();
        }

        return result;
    }
}