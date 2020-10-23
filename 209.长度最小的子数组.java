import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
/**
 * 利用滑动窗口来计算得到最短子数组
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //记录最短子数组的长度
        int res = 0;
        int sum = 0;
        //记录数组起始位置
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            //当子数组和满足>=s时，对长度进行修改判断
            while(sum >= s){
                res = res == 0 ? j-i+1 : Math.min(res, j-i+1);
                //逐步移除起始位置的数组元素，继续判断
                sum -= nums[i++];
            }
        }
        return res;
    }
}
// @lc code=end

