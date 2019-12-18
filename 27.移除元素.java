/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    /**
     * 给定一个数组和一个值，从数组中原地移除等于该值的元素
     * 返回移除元素后的新数组长度
     * 
     * 设定一个指针，标记当前位置，若当前值与给定值相等，则指针位置不变，
     * 不同则指针移动到下一个元素位置，以此记录数组长度
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if(nums == null){
            return 0;
        }
        //设定一个mark值来记录当前数组的长度
        int mark = 0;
        for (int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[mark] = nums[i];
                mark++;
            }
        }
        return mark;
    }
}
// @lc code=end

