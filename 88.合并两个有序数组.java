/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int index = m + n -1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[index] = nums1[p1];
                p1--;
                index--;
            }
            else{
                nums1[index] = nums2[p2];
                p2--;
                index--;
            }
        }
        // 因为若p1>=0，在[0, p1]中还没有进行判断，其本身就在nums1数组中，所以不需要移动了
        // while(p1 >= 0){
        //     nums1[index] = nums1[p1];
        //     index--;
        //     p1--;
        // }
        while(p2 >= 0){
            nums1[index] = nums2[p2];
            index--;
            p2--;
        }
    }
}
// @lc code=end

