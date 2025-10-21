class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int p1 = 0;
        int p2 = 0;
        int k = 0;

        int finalArray[] = new int[nums1.length + nums2.length];

        while(p1 < nums1.length && p2 < nums2.length){

            if(nums1[p1] < nums2[p2]){
                finalArray[k] = nums1[p1];
                p1++;
            }
            else{
                finalArray[k] = nums2[p2];
                p2++;
            }
            k++;
        }

        while(p1 < nums1.length){
            finalArray[k] = nums1[p1];
            p1++;
            k++;
        }

        while(p2 < nums2.length){
            finalArray[k] = nums2[p2];
            p2++;
            k++;
        }

        if(finalArray.length % 2 == 1){
            return finalArray[(finalArray.length) / 2];
        }
        else{

            int x = finalArray.length/2;

            double p = finalArray[x];
            double q = finalArray[x - 1];

            double ans = (p + q) / 2;

            return ans;
        }
        
    }
}