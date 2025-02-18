class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();

        int pt1 = 0;
        int pt2 = 0;


        while(pt1 < word1.length() && pt2 < word2.length()){

            sb.append(word1.charAt(pt1));
            pt1++;

            sb.append(word2.charAt(pt2));
            pt2++;

        }

        while(pt1 < word1.length()){
            sb.append(word1.charAt(pt1));
            pt1++;
        }

        while(pt2 < word2.length()){
            sb.append(word2.charAt(pt2));
            pt2++;
        }

        return sb.toString();
    }

    
}