class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        
        //use pointers on each strings
        int j = 0;

        //loop through characters in str1
        for(int i = 0; i < str1.length(); i++){

            //main logic -> if char(j) exists in str1 OR if char(j) - 1 exists in str1, j++; mod 26 to make it cyclic 
            if(str1.charAt(i) == str2.charAt(j) || (str1.charAt(i) - 'a' + 1) % 26 == str2.charAt(j) - 'a'){
                j++;
            }

            //once str2 pointer == length, return 
            if(j == str2.length()) return true;
        }

        return false;
    
    }
}