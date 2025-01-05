class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n = s.length();

        //final shifted array
        int[] arr = new int[n];

        for(int[] shift : shifts){

            //if shift is forward, ++ starting ind and -- (end + 1) ind
            if(shift[2] == 1){
                arr[shift[0]]++;

                if(shift[1] + 1 < n){
                    arr[shift[1] + 1]--;
                }
            }

             //if shift is backward, -- starting ind and ++ (end + 1) ind
            else{
                arr[shift[0]]--;

                if(shift[1] + 1 < n){
                    arr[shift[1] + 1]++;
                }
            }
        } 

        StringBuilder result = new StringBuilder(s);

        int sum = 0;

        for(int i = 0; i < n; i++){

            sum = (sum + arr[i]) % 26;

            if(sum < 0) sum += 26;

            char shiftedChar = (char) ('a' + ((s.charAt(i)) - 'a' + sum) % 26);

            result.setCharAt(i, shiftedChar);

        }

        return result.toString();
    }
}