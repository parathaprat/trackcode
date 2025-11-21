/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {

        int res = 0;

        if(bottomLeft[0] <= topRight[0] && bottomLeft[1] <= topRight[1] && sea.hasShips(topRight, bottomLeft)){

            if(bottomLeft[0] == topRight[0] && bottomLeft[1] == topRight[1]) return 1;

            int newX = (bottomLeft[0] + topRight[0])/2;
            int newY = (bottomLeft[1] + topRight[1])/2;

            //topLeft
            int[] topLeftTR = {newX, topRight[1]};
            int[] topLeftBL = {bottomLeft[0], newY + 1};
            res += countShips(sea, topLeftTR, topLeftBL);

            //topRight
            int[] topRightTR = topRight;
            int[] topRightBL = {newX + 1, newY + 1};
            res += countShips(sea, topRightTR, topRightBL);

            //bottomRight
            int[] bottomRightTR = {topRight[0], newY};
            int[] bottomRightBL = {newX + 1, bottomLeft[1]};
            res += countShips(sea, bottomRightTR, bottomRightBL);

            //bottomLeft
            int[] bottomLeftTR = {newX, newY};
            int[] bottomLeftBL = bottomLeft;
            res+= countShips(sea, bottomLeftTR, bottomLeftBL);
        }

        return res;
        
    }
}