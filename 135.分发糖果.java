/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
/**
 * 左规则：当 ratings[i - 1] < \ratings[i]时，
 * i 号学生的糖果数量将比 i−1 号孩子的糖果数量多。

 * 右规则：当ratings[i] > ratings[i + 1]时，
 * i 号学生的糖果数量将比 i + 1 号孩子的糖果数量多。
 * 我们遍历该数组两次，处理出每一个学生分别满足左规则或右规则时，
 * 最少需要被分得的糖果数量。每个人最终分得的糖果数量即为这两个数量的最大值。
 * 
 * 在计算右规则的时候只需要用单个变量记录当前位置的右规则，同时计算答案即可。
 */
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if(i > 0 && ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }else{
                left[i] = 1;
            }
        }

        int right = 0, ret = 0;
        for (int i = n-1; i >= 0; i--) {
            if(i < n-1 && ratings[i] > ratings[i+1]){
                right++;
            }else{
                right=1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }
}
// @lc code=end

