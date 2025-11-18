class Solution {
    public String reverseWords(String s) {

        String result = "";

        String[] arr = s.trim().split("\\s+");

        for(int i = arr.length -1; i > 0; i--){
            result += arr[i] + " ";
        }

        //to avoid a trailing space
        return result + arr[0];


        
    }
}