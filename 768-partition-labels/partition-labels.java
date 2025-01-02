class Solution {
    public List<Integer> partitionLabels(String s) {
        
        if(s == null || s.length() == 0){
            return null;
        }

        List<Integer> output = new ArrayList<>();

        int[] last_indices = new int[26];

        //log the last index where each letter in string appears
        for(int i = 0; i < s.length(); i++){

            last_indices[s.charAt(i) - 'a'] = i;
            
        }

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){

            //for each letter in string, update end to the last index where that letter appears 
            end = Math.max(end, last_indices[s.charAt(i) - 'a']);

            //at the point where the current index becomes end, place a partition
            if(i == end){
                output.add(end - start + 1);
                start = end + 1;
            }
        }

        return output;
    }
}