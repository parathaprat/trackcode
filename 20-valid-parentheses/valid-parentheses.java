class Solution {
    public boolean isValid(String s) {

        if(s == null) return true;

        Stack<Character> open = new Stack<>();
        
        for(char c : s.toCharArray()){

            if(c == '(' || c == '[' || c == '{'){
                open.add(c);
            }
            else{

                if(open.isEmpty()) return false;

                if(c == ')' && open.peek() == '(' ||
                c == ']' && open.peek() == '[' ||
                c == '}' && open.peek() == '{'){
                    open.pop();
                }
                else{
                    return false;
                }

            }

            
        }

        return open.isEmpty();
    }
}