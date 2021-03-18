/*
 * @lc app=leetcode.cn id=1037 lang=java
 *
 * [1037] 有效的回旋镖
 */

// @lc code=start
class Solution {
    public boolean isBoomerang(int[][] points) {
        //首先判断点相同和三点共线的情况
        if(points[0][0] == points[1][0] && points[0][1] == points[1][1] ||
            points[0][0] == points[2][0] && points[0][1] == points[2][1] ||
            points[1][0] == points[2][0] && points[1][1] == points[2][1] ||
            points[0][0] == points[1][0] && points[0][0] == points[2][0]){
                return false;
            }
        //再判断两点共线的情况
        if(points[0][0] == points[1][0] || points[0][0] == points[2][0] ||
            points[1][0] == points[2][0]) return true;
        //最后求斜率进行比较
        double k1 = (double)(points[1][1] - points[0][1])/(points[1][0] - points[0][0]);
        double k2 = (double)(points[2][1] - points[0][1])/(points[2][0] - points[0][0]);
        double k3 = (double)(points[2][1] - points[1][1])/(points[2][0] - points[1][0]);
        //若斜率都相等，那么返回false
        if(k1 == k2 && k2 == k3) return false;
        return true;
    }
}
// @lc code=end

