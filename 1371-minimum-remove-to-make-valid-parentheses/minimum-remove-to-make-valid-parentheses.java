class Solution {
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder sb = new StringBuilder();

        int open = 0;

        //first pass removed unmatched )
        for(char c : s.toCharArray()){

            if(c == '(') open++;
            else if(c == ')'){
                if(open == 0) continue;
                open--;
            }

            sb.append(c);
        }

        StringBuilder result = new StringBuilder();

        //2nd pass removed unmatched (
        for(int i = sb.length() - 1; i >= 0; i--){
            
            if(sb.charAt(i) == '(' && open-- > 0) continue;

            result.append(sb.charAt(i));
        }

        return result.reverse().toString();
    }
}