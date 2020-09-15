import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //首先判空，分开判断
        int m = matrix.length; 
        if(m == 0) return res;
        int n = matrix[0].length;
        if( n == 0) return res;
        //确定4个边界
        int up = 0, down = m-1, left = 0, right = n-1;
        while(true){
            //先遍历从左到右，添加元素
            for(int i=left; i <= right; i++) res.add(matrix[up][i]);
            //上边界下移一位，若左边界大于右边界，则跳出
            if(++up > down) break;
            //然后遍历从上到下，添加元素
            for(int i = up; i <= down; i++) res.add(matrix[i][right]);
            //右边界左移一位，若右边界小于左边界，则跳出
            if(--right < left) break;
            //接着遍历从右到左，添加元素
            for(int i = right; i >= left; i--) res.add(matrix[down][i]);
            //下边界上移一位，若下边界小于上边界，则跳出
            if(--down < up) break;
            //再遍历从下到上，添加元素
            for(int i = down; i >= up; i--) res.add(matrix[i][left]);
            //左边右移一位，若左边界大于右边界，则跳出
            if(++left > right) break;
        }
        return res;
    }
}
// @lc code=end

