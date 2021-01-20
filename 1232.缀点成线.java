/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 缀点成线
 */

// @lc code=start
/**
 * 两点连成一条直线，首先用两个点，计算出直线的k，b
 * 然后遍历判断后续节点是否满足该k,b构成的直线？
 */
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) return true;
        //记录第一个点的坐标，将列表中所有节点都按照该点移动
        int x = coordinates[0][0], y = coordinates[0][1];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i][0] -= x;
            coordinates[i][1] -= y;
        }
        //则通过前两个点的直线过原点，可令直线为Ax+By = 0
        //将第一个点带入，可得到A，B的值，即可得到该直线的表达式
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < coordinates.length; i++) {
            if(A*coordinates[i][0] + B*coordinates[i][1] != 0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

