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

        if(bottomLeft[0] <= topRight[0] && bottomLeft[1] <= topRight[1] && sea.hasShips(topRight, bottomLeft) == true){

            if(topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;

            int newX = (topRight[0] + bottomLeft[0])/2;
            int newY = (topRight[1] + bottomLeft[1])/2;

            //topLeft
            res += countShips(sea, new int[]{newX, topRight[1]}, new int[]{bottomLeft[0], newY + 1});

            //topRight
            res += countShips(sea, topRight, new int[]{newX + 1, newY + 1});

            //bottomRight
            res += countShips(sea, new int[]{topRight[0], newY}, new int[]{newX + 1, bottomLeft[1]});

            //bottomLeft
            res += countShips(sea, new int[]{newX, newY}, bottomLeft);

        }

        return res;

    }
}