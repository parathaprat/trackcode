class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        //create a prefix sum array with solutions
        int[] prefixSum = new int[words.length];

        int valid = 0;

        int i = 0;

        for(String word : words){

            if(validWord(word)){
                valid++;
            }

            prefixSum[i++] = valid;
        }

        int result[] = new int[queries.length];

        i = 0;

        //use prefix sum to calculate result 
        for(int[] query : queries){
            result[i++] = prefixSum[query[1]] - (query[0] == 0 ? 0 : prefixSum[query[0] - 1]);
        }

        return result;
    }

    //helper functions to build prefix sum array
    boolean validWord(String word){

        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; 
    }


}