class Solution {
    public int myAtoi(String s) {

        s = s.trim();

        if(s.isEmpty()) return 0;

        int result = 0;
        int sign = 1;
        int i = 0;

        if(s.charAt(0) == '-'){
            sign = -1;
            i++;
        }
        else if(s.charAt(0) == '+'){
            i++;
        }

        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE/10 && digit > 7)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
        
    }
}