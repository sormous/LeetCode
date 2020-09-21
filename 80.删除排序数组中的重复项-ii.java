/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
/**
 * 利用两个指针cur、s,
 * 分别指向遍历数组的当前位置和最后存储数组进行到的位置
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        //count表示数组中元素当前的个数，从1开始计数
        int s = 0, count = 1;
        //从第二个数开始遍历
        for (int cur = 1; cur < nums.length; cur++) {
            if(nums[cur] == nums[s]){
                count++;
                //当计数小于等于2时，存储数组位置指针后移一位
                if(count <= 2){
                    s++;
                }
            }
            //当遍历到不重复的元素时，重置count计数，并且存储数组位置指针后移一位
            else{
                count = 1;
                s++;
            }
            //每次遍历将遍历到的位置的元素值赋给存储位置上
            nums[s] = nums[cur];
        }
        //最后返回s+1表示当前数组的长度
        return s+1;
    }
}
// @lc code=end

