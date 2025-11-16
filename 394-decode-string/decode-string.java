class Solution {
    public String decodeString(String s) {

        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> st1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for(char c : s.toCharArray()){

            //if number store and wait for more digits
            if(Character.isDigit(c)){
                n = n * 10 + (c - '0');
            }

            //if opening, push to stack, reset number and sb
            else if(c == '['){
                st.push(n);
                n = 0;

                st1.push(sb);
                sb = new StringBuilder();
            }

            //if closing, take top number, store sb in temp; take top of sb stack, and append temp k times to sb.
            else if(c == ']'){
                
                int k = st.pop();
                StringBuilder temp = sb;

                sb = st1.pop();

                while(k-- > 0){
                    sb.append(temp);
                }
            }
            //if nothing, just append to sb
            else{
                sb.append(c);
            }
        }

        return sb.toString();

        
    }
}