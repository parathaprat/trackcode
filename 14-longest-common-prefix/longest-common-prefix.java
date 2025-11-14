class Solution {
    public String longestCommonPrefix(String[] strs) {

        String track = strs[0];

        for(int i = 0; i < strs.length; i++){

            while(strs[i].indexOf(track) != 0){

                track = track.substring(0, track.length() - 1);

            }
        }

        return track;
    }
}