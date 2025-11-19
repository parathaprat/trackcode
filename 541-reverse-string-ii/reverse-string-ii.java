class Solution {
    public String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();
        int n = chars.length;

        //process string in chunks of 2l
        for(int start = 0; start < n; start += 2 * k){

            int end = start + k - 1;

            if(end >= n - 1) end = n - 1;

            reverse(start, end, chars);

        }

        return new String(chars);
    }

    private void reverse(int i, int j, char[] chars){

        while(i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }
    }
}