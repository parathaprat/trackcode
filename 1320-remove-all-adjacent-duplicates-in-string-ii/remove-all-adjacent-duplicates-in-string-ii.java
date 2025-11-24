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

                if(st.peek().freq == k) st.pop();
            }
            else st.push(new tuple(c, 1));
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