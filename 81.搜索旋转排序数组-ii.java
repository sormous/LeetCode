/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int start = 0, end = nums.length-1, mid;
    
        while(start <= end){
            mid = start + (end-start)/2;
            if(target == nums[mid]) return true;
            //当第一个元素值等于中间元素值，那么改变start值，去除重复值
            if(nums[start] == nums[mid]){
                start++;
                continue;
            }
            //当第一个元素值小于中间元素值，则证明数组前半部分有序
            if(nums[start] < nums[mid]){
                //若target在前半部分值的范围中，那么在前半部分找
                if(target >= nums[start] && target < nums[mid]){
                    end = mid-1;
                }
                //否则在后半部分寻找
                else{
                    start = mid+1;
                }
            }
            //若第一个元素值大于中间元素值，则证明数组后半部分有序
            else{
                //若target在后半部分值的范围中，那么在后半部分找
                if(target <= nums[end] && target > nums[mid]){
                    start = mid+1;
                }
                //否则在前半部分寻找
                else{
                    end = mid-1;
                }
            }
        }
        return false;
    }
}
// @lc code=end

