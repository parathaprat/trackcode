class Solution {
    public String decodeString(String s) {

        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int n = 0;

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

                StringBuilder temp = sb;
                sb = sbStack.pop();

                int k = st.pop();

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