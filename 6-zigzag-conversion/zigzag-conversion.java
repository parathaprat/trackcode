class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1) return s;

        StringBuilder sb = new StringBuilder();
        int cycle = 2 * (numRows - 1);

        for(int row = 0; row < numRows; row++){
            for(int j = row; j < s.length(); j+= cycle){

                sb.append(s.charAt(j));

                boolean isMiddle = row > 0 && row < numRows - 1;
                int diagonalIndex = j + (cycle - 2 * row);

                if(isMiddle && diagonalIndex < s.length()) sb.append(s.charAt(diagonalIndex));
            }
        }

        return sb.toString();
        
    }
}