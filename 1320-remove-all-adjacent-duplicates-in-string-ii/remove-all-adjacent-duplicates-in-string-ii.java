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

        st = new Stack<>();

        for(char c : s.toCharArray()){

            if(!st.isEmpty() && st.peek().c == c) st.peek().freq++;
            else{
                st.add(new tuple(c, 1));
            }

            if(st.peek().freq == k) st.pop();
        }

        StringBuilder sb = new StringBuilder();

        for(tuple tp : st){

            int f = tp.freq;

            while(f > 0){
                sb.append(tp.c);
                f--;
            }
        }

        return sb.toString();
        
    }
}