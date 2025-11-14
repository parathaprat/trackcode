class Solution {
    public String longestCommonPrefix(String[] strs) {
        

        //Assign the first string as prefix
        //check others for prefix, keep reducing len
        

        String track = strs[0];

        for(int i = 0; i < strs.length; i++){

            //while string does not start with track, keep reducing
            while(strs[i].indexOf(track) != 0){
                track = track.substring(0, track.length() - 1);
            }
        }

        return track;
    }
}