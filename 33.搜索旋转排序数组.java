/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
/**
 * 二分查找问题：
 * 不断寻找有序的那一段数组区间，只在有序的数组区间中进行操作
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int l = 0, r=nums.length-1;
        while(l <= r){
            int mid=l+(r-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            //若nums[mid] < nums[r]则表示mid右边为有序数组
            if(nums[mid] < nums[r]){
                //若target在mid右区间
                if(nums[mid] < target && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
            //否则mid左边为有序数组
            else{
                //若target在mid左区间
                if(nums[l] <= target && target < nums[mid]){
                    r = mid-1;
                }else{
                    l=mid+1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

