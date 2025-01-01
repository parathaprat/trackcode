class Solution {
    public int maxScore(String s) {
        
        int ans = 0;

        //loop through string until 2nd last element 
        for(int i = 0; i < s.length() - 1; i++){

            int curr = 0;

            //count 0s left of i
            for(int j = 0; j <= i; j++){
                if(s.charAt(j) == '0'){
                    curr++;
                }
            }

            //count 1s right of i
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(j) == '1'){
                    curr++;
                }
            }

            //find max value of curr between each partition
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}