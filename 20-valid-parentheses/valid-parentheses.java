class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){

            //push opening bracket chars to stack
            if(ch == '(' || ch == '[' | ch == '{'){
                stack.push(ch);
            } 

            //if stack empty, false; pop top, check complements
            else{
                if(stack.isEmpty()) return false;

                char top = stack.pop();

                //only valid way this moves forward
                if(ch == ')' && top == '(' || ch == ']' && top == '[' || ch == '}' && top == '{') continue;
                
                else return false;

            }
        }

        return stack.isEmpty();


    }
}