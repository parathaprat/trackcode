class Solution {
    public String decodeString(String s) {

        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();

        int n = 0;

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){

            if(Character.isDigit(c)){
                n = n * 10 + (c - '0');
            }
            else if(c == '['){

                st.push(n);
                n = 0;

                sbStack.push(sb);
                sb = new StringBuilder();
            }
            else if(c == ']'){

                int k = st.pop();

                StringBuilder temp = sb;
                sb = sbStack.pop();

                while(k > 0){
                    sb.append(temp);
                    k--;
                }
            }

            else sb.append(c);
        }

        return sb.toString();
        
    }
}