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
                            //将长度较小的数组调整位置
                            if(nums1.length - start1 > nums2.length - start2){
                                return findKth(nums2, start2, nums1, start1, k);
                            }
                            
                            //较少元素数组已到末尾
                            if(nums1.length == start1){
                                return nums2[start2+k-1];
                            }
                            if(k==1){
                                return Math.min(nums1[start1], nums2[start2]);
                            }

                            //在num1, nums2数组中各找一半的数，相当于每次丢掉要查总数的1/4
                            int half = Math.min(k/2, nums1.length-start1);
                            // nums1数组中可找的位置
                            int ia = half + start1;
                            // nums2数组中可找的位置
                            int ib = k - half + start2;

                            // nums1[start, ..., ia-1, ia, ..., nums1.length]
                            // nums2[start, ..., ib-1, ib, ..., nums2.length]

                            if(nums1[ia-1] < nums2[ib-1]){
                                // 说明子数组nums1[start, ..., ia-1]可以弃了，要找的值在nums1[ia, ..., nums1.length]
                                // 和nums2[start, ..., ib-1, ib, ..., nums2.length]中
                                return findKth(nums1, ia, nums2, start2, k-(ia-start1));
                            }

                            else if(nums1[ia-1] > nums2[ib-1]){
                                // 说明子数组nums2[start, ..., ib-1]可以弃了，要找的值在nums2[ib, ..., nums2.length]
                                // nums1[start, ..., ia-1, ia, ..., nums1.length]
                                return findKth(nums1, start1, nums2, ib, half);
                            }
                            else{
                                // 两个值相等说明找到了
                                return nums1[ia-1];
                            }
                        }
}
// @lc code=end

