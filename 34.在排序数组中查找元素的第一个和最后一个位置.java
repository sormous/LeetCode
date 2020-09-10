/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
/**
 * 利用二分思想找到左右边界
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int[] res = {-1, -1};
        if(nums.length == 0) return res;
        //找左边界，由右侧逼近
        while(l<r){
            int mid = l+(r-l)/2;
            //选择逼近方式，>=表示从右侧逼近
            if(nums[mid] >= target){
                r=mid;
            }
            else l=mid+1;
        }
        //若找到最后没有等于target值的元素，则直接返回初始数组
        if(nums[l] != target)  return res;
        res[0] = l;
        r=nums.length;
        //找右边界，由左侧逼近
        while(l<r){
            int mid = l+(r-l)/2;
            //<=表示从左侧逼近
            if(nums[mid] <= target) l=mid+1;
            else r=mid;
        }
        res[1] = l-1;

        return res;
    }
}
// @lc code=end

