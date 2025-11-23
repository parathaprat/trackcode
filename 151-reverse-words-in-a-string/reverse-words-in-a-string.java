class Solution {
    public String reverseWords(String s) {

        String ans = "";

        String[] arr = s.trim().split("\\s+");

        for(int i = arr.length - 1; i > 0; i--){
            ans += arr[i] + " ";
        }

        return ans + arr[0];



        
    }
}