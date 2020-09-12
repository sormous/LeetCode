/*
 * @lc app=leetcode.cn id=593 lang=java
 *
 * [593] 有效的正方形
 */

// @lc code=start
/**
 * 可以转换成任意三个点构成一个直角三角形
 */
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isRightTrianle(p1, p2, p3) && isRightTrianle(p1, p2, p4) &&
            isRightTrianle(p1, p3, p4) && isRightTrianle(p2, p3, p4);
    }

    //由三个点的坐标值来判断是否为直角三角形
    private boolean isRightTrianle(int[] p1, int[] p2, int[] p3){
        int d1 = (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
        int d2 = (p1[0]-p3[0])*(p1[0]-p3[0]) + (p1[1]-p3[1])*(p1[1]-p3[1]);
        int d3 = (p2[0]-p3[0])*(p2[0]-p3[0]) + (p2[1]-p3[1])*(p2[1]-p3[1]);
        if(d1>d2 && d2==d3 && d2+d3==d1 ||
            d2>d1 && d1==d3 && d1+d3==d2 ||
            d3>d1 && d1==d2 && d1+d2==d3){
                return true;
            }
        return false;
    }
}
// @lc code=end

