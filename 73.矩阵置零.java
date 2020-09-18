/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        //第一行和第一列的标记相同都为matrix[0][0]，所以需要一个额外的变量来标记第一列
        //我们利用matrix[0][0]来记录第一行是否需要置0
        //用isCol来记录第一列是否需要置0
        boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;
        //判断第一列是否需要置零
        for (int i = 0; i < R; i++) {
            if(matrix[i][0] == 0){
                isCol = true;
            }
            //若某元素值为0.则将其第一列和第一行的值置为0，标记该行和该列需要置0
            for (int j = 1; j < C; j++) {
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //从第二行和第二列开始遍历，如果该行和该列被标记了，那么该元素值置0
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //第一行元素置0
        if(matrix[0][0] == 0){
            for (int i = 0; i < C; i++) {
                matrix[0][i] = 0;
            }
        }
        //第一列元素置0
        if(isCol){
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }

        



    }
}
// @lc code=end

