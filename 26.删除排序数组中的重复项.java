/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    /**
     * 给定一个数组，将数组中的重复元素去掉，并且返回新数组的元素个数
     * 不要创建新的数组来保存，在常量时间解决
     * 
     * 从第二个元素开始处理，记为当前元素，如果当前元素与前一个相同则删除，
     * 如果不同则将它移动到正确的位置，返回最后数组的元素个数
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        //首先判断特殊情况，数组为空
        if(nums == null){
            return 0;
        }
        if(nums.length < 2){
            return nums.length;
        }
        //设定一个mark标记当前数组的元素位置
        int mark = 0;
        int l = nums.length;
        //从第二个元素开始比较
        for(int i=1; i<l; i++){
            if(nums[i] != nums[mark]){
                nums[mark+1] = nums[i];
                mark += 1;
            }
        }
        return mark+1;
    }
}
// @lc code=end

