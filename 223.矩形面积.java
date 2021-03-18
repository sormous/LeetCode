/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
// 因为题中给出的节点，分别为两矩阵的左下和右上节点，
// 所以可以借助这一特性来进行判断是否重叠和重叠区域
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //首先判断满足以下任意一种情况，都不存在重叠的区域，则直接返回两矩阵面积相加
        if(A >= G || B >= H || C <= E || D <= F){
            return (C-A)*(D-B)+(G-E)*(H-F);
        }

        //有重叠
        //则找出重叠矩阵的上下左右边界
        int up = Math.min(D, H);
        int down = Math.max(B, F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);

        return (C-A)*(D-B)+(G-E)*(H-F)-(up-down)*(right-left);
    }
}
// @lc code=end

