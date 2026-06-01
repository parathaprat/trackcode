class Solution {
    public String decodeString(String s) {

        //sb to store chars until num
        //stack to store num
        //sb stack to store string

        Stack<Integer> st = new Stack<>(); //store nums
        Stack<StringBuilder> sbStack = new Stack<>(); //store stack of string until nums, nested
        StringBuilder sb = new StringBuilder(); //store string

        int n = 0;

        for(char c : s.toCharArray()){

            if(Character.isDigit(c)){
                n = n * 10 + c - '0';
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