class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        //split given string from each space
        String[] strs = sentence.split(" ");

        //cyce through each word string array 
        for(int i = 0; i < strs.length; i++){
            String word = strs[i];

            //if len of word is less than given searchword, continue
            if(word.length() < searchWord.length()){
                continue;
            }

            //if searchword = substring of word from 0 to len(searchword)
            if(searchWord.equals(word.substring(0, searchWord.length()))){

                //since it is 0 indexed and ans is 1 indexed
                return i + 1;
            }
        
        }

        return -1;


    }
}