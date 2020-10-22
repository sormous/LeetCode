/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
/**
 * 分别找出数组中最大和第二大的数字，然后进行比较
 * 该题测试用例有个问题，若只有一个数或者全部数字相等时，为什么返回0？
 */
class Solution {
    public int dominantIndex(int[] nums) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        //首先找到最大数和最大数的索引位置
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        //然后找到第二大数值
        for (int num : nums) {
            if(num > secondMax && num < max){
                secondMax = num;
            }
        }
        //如果所有数相等，或者第二大数字为0，或者最大数是第二大数的两倍以上，则直接返回索引
        if(secondMax == Integer.MIN_VALUE || secondMax == 0 || max/secondMax >= 2) return index;
        else return -1;
    }
}
// @lc code=end

