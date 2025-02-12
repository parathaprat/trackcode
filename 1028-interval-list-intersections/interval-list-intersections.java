class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        if(firstList.length == 0 || secondList.length == 0) return new int[0][0];

        int p1 = 0;
        int p2 = 0;

        List<int[]> res = new ArrayList<>();

        while(p1 < firstList.length && p2 < secondList.length){

            //get start and end of each interval
            int start1 = firstList[p1][0];
            int end1 = firstList[p1][1];
            int start2 = secondList[p2][0];
            int end2 = secondList[p2][1];

            if(start1 <= end2 && start2 <= end1){

                res.add(new int[]{Math.max(start1, start2), Math.min(end2, end1)});
            }

            if(end1 < end2) p1++;
            else p2++;
        }

        return res.toArray(new int[res.size()][2]);

         
    }
}