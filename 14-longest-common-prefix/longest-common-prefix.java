class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        //assign first string as prefix
        String track = strs[0];

        //loop thru other strings, keep reducing the track string until prefix is obtained

        for(int i = 1; i < strs.length; i++){

            //keep removing chars till we dont get a starting index for track in strs[i]
            while(strs[i].indexOf(track) != 0){

                track = track.substring(0, track.length() - 1);
            }
        }

        return track;

        
    }
}