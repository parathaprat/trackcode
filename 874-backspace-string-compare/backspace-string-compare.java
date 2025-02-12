class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        //stack and stringbuilder
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        //building final s string
        for(char c : s.toCharArray()){

            if(c != '#'){
                st.push(c);
            }
            else{
                if(!st.isEmpty()) st.pop();
            }
        }

        //pop from stack and add to sb
        for(Character ch : st){

            sb.append(ch);

        }

        String sFinal = sb.toString();

        //reset both to build t

        st.clear();
        sb.setLength(0);

        for(char c : t.toCharArray()){

            if(c != '#'){
                st.push(c);
            }

            else{
                if(!st.isEmpty()) st.pop();
            }

        }

        for(Character ch : st){

            sb.append(ch);
        }

        String tFinal = sb.toString();

        return sFinal.equals(tFinal);
    }
}