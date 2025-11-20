class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){

            if(c == '[' || c == '{' || c == '(') st.add(c);
            else if(st.isEmpty()) return false;
            else if(
                c == ')' && st.peek() == '(' || 
                c == '}' && st.peek() == '{' || 
                c == ']' && st.peek() == '['
            ) st.pop();
            else return false;
        }

        return st.isEmpty();
        
    }
}