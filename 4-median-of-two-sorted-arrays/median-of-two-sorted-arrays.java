class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merge = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int m = 0;

        while(i < nums1.length && j < nums2.length && m < nums1.length + nums2.length){

            if(nums1[i] < nums2[j]){
                merge[m] = nums1[i];
                i++;
                m++;
            }
            else{
                merge[m] = nums2[j];
                j++;
                m++;
            }
        }

        while(i < nums1.length){
            merge[m] = nums1[i];
            i++;
            m++;
        }

        while(j < nums2.length){
            merge[m] = nums2[j];
            j++;
            m++;
        }

        int mid = merge.length/2;

        return merge.length % 2 == 0 ? (merge[mid] + merge[mid - 1])/2.0 : merge[mid];
    }
}