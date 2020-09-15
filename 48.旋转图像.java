/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        r(matrix, 0, len-1, len-1);
    }

    private void r(int[][] matrix, int start, int end, int num){
        if(start < end){
            //从外围开始旋转，遍历n-1次，四方旋转
            for (int i = 0; i < num; i++) {
                int temp = matrix[start][start+i];
                matrix[start][start+i] = matrix[end-i][start];
                matrix[end-i][start] = matrix[end][end-i];
                matrix[end][end-i] = matrix[start+i][end];
                matrix[start+i][end] = temp;
            }
            //向中间缩进一圈，去除首尾，旋转的长度变为num-2
            r(matrix, start+1, end-1, num-2);
        }
    }
}
// @lc code=end

