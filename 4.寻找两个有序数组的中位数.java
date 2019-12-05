/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if(total % 2 != 0){
            return findKth(nums1, 0, nums2, 0, total/2+1);
        }else{
            return (findKth(nums1, 0, nums2, 0, total/2)
                    + findKth(nums1, 0, nums2, 0, total/2+1))/2.0;
        }
    }
    /**
     * 在数组中找出第k大的元素
     * @param nums1
     * @param start1
     * @param nums2
     * @param start2
     * @param k  要找的中位数位置
     * @return
     */
    public int findKth(int[] nums1, final int start1,
                        int[] nums2, final int start2,
                        final int k){
                            if(nums1.length - start1 > nums2.length - start2){
                                return findKth(nums2, start2, nums1, start1, k);
                            }
                            
                            if(nums1.length == start1){
                                return nums2[start2+k-1];
                            }
                            if(k==1){
                                return Math.min(nums1[start1], nums2[start2]);
                            }
                            int half = Math.min(k/2, nums1.length-start1);
                            int ia = half + start1;
                            int ib = k - half + start2;
                            if(nums1[ia-1] < nums2[ib-1]){
                                return findKth(nums1, ia, nums2, start2, k-(ia-start1));
                            }
                            else if(nums1[ia-1] > nums2[ib-1]){
                                return findKth(nums1, start1, nums2, ib, half);
                            }
                            else{
                                return nums1[ia-1];
                            }
                        }
}
// @lc code=end

