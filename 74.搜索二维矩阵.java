/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
/**
 * 该题因为从左到右且每行第一个数大于前一行最后一个数，
 * 所以可以看作一个有序数组序列
 * 直接采用二分查找法即可
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //首先判空
        if(matrix.length == 0) return false;
        int R = matrix.length, C = matrix[0].length;
        int begin = 0, mid, end = R*C-1;
        while(begin <= end){
            mid = (begin+end)/2;
            //对列数做除和求余即可找到坐标
            if(target == matrix[mid/C][mid%C]){
                return true;
            }
            else{
                if(target < matrix[mid/C][mid%C]){
                    end = mid-1;
                }else{
                    begin = mid+1;
                }
            }
        }
        return false;
    }
}


        
// @lc code=end

