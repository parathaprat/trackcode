class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        char[] result = new char[s.length() + spaces.length];

        //pointers for spaces, string and ans
        int space = 0;
        int str = 0;
        int ans = 0;

        while(space < spaces.length && str < s.length()){

            //index where spces have to be inserted
            int insertionIndex = spaces[space];

            //insert chars before we hit a insertion index
            while(str < insertionIndex && str < s.length()){
                result[ans] = s.charAt(str);
                ans++;
                str++;
            }

            //at insertion index, insert spaces
            result[ans] = ' ';
            ans++;
            space++;
        }

        //append rest of the chars
        while(str < s.length()){
            result[ans] = s.charAt(str);
            ans++;
            str++;
        }

        return new String(result);
    }
}