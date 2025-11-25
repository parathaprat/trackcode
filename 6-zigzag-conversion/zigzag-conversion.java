class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1) return s;

        int cycle = 2 * (numRows - 1);

        StringBuilder sb = new StringBuilder();

        for(int row = 0; row < numRows; row++){
            for(int j = row; j < s.length(); j+= cycle){

                sb.append(s.charAt(j));

                boolean isMiddle = (row > 0 && row < numRows - 1);

                int mIndex = j + (cycle - 2 * row);
                if(isMiddle && mIndex < s.length()) sb.append(s.charAt(mIndex));

            }
        }

        return sb.toString();
        
    }
}