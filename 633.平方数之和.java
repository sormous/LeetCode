/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
/**
 * 利用双指针的思想
 * 分别从0~sqrt(c)进行遍历，判断是否存在有满足平方和=c的实例存在
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0;
        //进行剪枝，直接将右边界定义在c的平方根处
        int r = (int)Math.sqrt(c);
        while(l<=r){
            int sum = l*l + r*r;
            if(sum == c) return true;
            else if(sum > c){
                r--;
            }else{
                l++;
            }
        }
        return false;
    }
}
// @lc code=end

