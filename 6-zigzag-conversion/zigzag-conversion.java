class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1) return s;

        int cycle = 2 * (numRows - 1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numRows; i++){
            for(int j = i; j < s.length(); j += cycle){

                sb.append(s.charAt(j));

                boolean isMiddle = i > 0 && i < numRows - 1;
                int diagonalIndex = j + (cycle - 2 * i);

                if(isMiddle && diagonalIndex < s.length()) sb.append(s.charAt(diagonalIndex));

            }
        }
        
        return sb.toString();
    }
}