class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];

        int p1 = 0;
        int p2 = 0;

        int a = 0;

        while(p1 < nums1.length && p2 < nums2.length){

            if(nums1[p1] < nums2[p2]){
                arr[a] = nums1[p1];
                p1++;
                a++;
            }
            else{
                arr[a] = nums2[p2];
                p2++;
                a++;
            }
        }

        while(p1 < nums1.length){
            arr[a] = nums1[p1];
            p1++;
            a++;
        }

        while(p2 < nums2.length){
            arr[a] = nums2[p2];
            p2++;
            a++;
        }


        int mid = arr.length/2;

        return arr.length % 2 != 0 ? arr[mid] : (arr[mid] + arr[mid - 1]) / 2.0;        
    }
}