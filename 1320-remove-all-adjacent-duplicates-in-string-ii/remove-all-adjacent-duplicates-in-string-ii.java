class Solution {

    class tuple{

        char c;
        int freq;

        tuple(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }

    Stack<tuple> st;


    public String removeDuplicates(String s, int k) {

        //use a tuple of char and freq in a stack to track freqs and pop accordingly

        st = new Stack<>();

        for(char c : s.toCharArray()){

            if(!st.isEmpty() && st.peek().c == c){
                st.peek().freq++;
            }
            else{
                st.add(new tuple(c, 1));
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