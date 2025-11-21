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

            if(bottomLeft[1] == topRight[1] && bottomLeft[1] == topRight[1]) return 1;

            int newX = (topRight[0] + bottomLeft[0])/2;
            int newY = (topRight[1] + bottomLeft[1])/2;

            //topLeft
            int[] topLeftTopRight = {newX, topRight[1]};
            int[] topLeftBottomRight = {bottomLeft[0], newY + 1};

            res += countShips(sea, topLeftTopRight, topLeftBottomRight);

            //topRight
            int[] topRightTopRight = topRight;
            int[] topRightBottomLeft = {newX + 1, newY + 1};

            res += countShips(sea, topRightTopRight, topRightBottomLeft);

            //bottomRight
            int[] bottomRightTopRight = {topRight[0], newY};
            int[] bottomRightBottomLeft = {newX + 1, bottomLeft[1]};

            res += countShips(sea, bottomRightTopRight, bottomRightBottomLeft);

            //bottomLeft
            int[] bottomLeftTopRight = {newX, newY};
            int[] bottomLeftBottomLeft = bottomLeft;

            res += countShips(sea, bottomLeftTopRight, bottomLeftBottomLeft);
        }

        return res;
        
    }
}