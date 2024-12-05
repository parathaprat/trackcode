class Solution {
    public boolean canChange(String start, String target) {
        
        //get length 
        int n = start.length();

        //define pointers to interate through both
        int startInd = 0;
        int tarInd = 0;

        while(startInd < n || tarInd < n){

            //move further if blank in each
            while(startInd < n && start.charAt(startInd) == '_') startInd++;
            while(tarInd < n && target.charAt(tarInd) == '_') tarInd++;

            //if both reach end, true; if one of them reaches end, false
            if(startInd == n && tarInd == n) return true;
            if(startInd == n || tarInd == n) return false;

            //main logic -> if char !=; or if L and start > tar; or if R and start > tar
            if(start.charAt(startInd) != target.charAt(tarInd) || 
            start.charAt(startInd) == 'L' && startInd < tarInd ||
            start.charAt(startInd) == 'R' && startInd > tarInd) return false;

            //increament pointers
            startInd++;
            tarInd++;
        }

        return true;
    }
}