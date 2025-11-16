class Solution {

    class tuple{

        char c;
        int freq;

        tuple(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }
    public String removeDuplicates(String s, int k) {

        Stack<tuple> st = new Stack<>();

        for(char c : s.toCharArray()){

            if(!st.isEmpty() && st.peek().c == c){
                st.peek().freq++;
            }
            else{
                st.push(new tuple(c, 1));
            }

            if(st.peek().freq == k) st.pop();
        }

        StringBuilder sb = new StringBuilder();

        for(tuple tp : st){
            sb.append(String.valueOf(tp.c).repeat(tp.freq));
        }

        return sb.toString();




        
    }
}