
//要求的时间复杂度为O(log(m+n))，但是在此完成O(m+n)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged_arr = this.merge_arr(nums1,nums2);
        int len = merged_arr.length;
        if(len % 2 ==1){
            return (double) merged_arr[len/2];
        }else{
            return ((double) merged_arr[len/2] + (double) merged_arr[len/2-1])/2;
        }
    }

    private int[] merge_arr(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] merged_arr = new int[len1+len2];
        int index_1 = 0;
        int index_2 = 0;
        int index_merged = 0;
        while (index_1<len1 && index_2<len2){
            if(nums1[index_1]<nums2[index_2]){
                merged_arr[index_merged++] = nums1[index_1++];
            }else{
                merged_arr[index_merged++] = nums2[index_2++];
            }
        }
        if(index_1<len1){
            while (index_1<len1){
                merged_arr[index_merged++] = nums1[index_1++];
            }
        } else if (index_2<len2) {
            while (index_2<len2){
                merged_arr[index_merged++] = nums2[index_2++];
            }
        }
        return merged_arr;
    }

    public static void main(String[] argv){
        int[] test1 = {1,3};
        int[] test2 = {2};
        System.out.print(new Solution().findMedianSortedArrays(test1,test2));
    }


}