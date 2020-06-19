/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //记录某行，某位数字是否已经被摆置
        boolean[][] row = new boolean[9][9];
        //记录某列，某位数字是否已经被摆置
        boolean[][] col = new boolean[9][9];
        //记录3*3宫格内，某位数字是否已经被摆列
        boolean[][] block = new boolean[9][9];
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    //因为数独中不会出现0，所以利用-'1'将char[1-9]转成int[0-8]，在bool数组中记录
                    int num = board[i][j] - '1';
                    //记录当前块号，竖向记录，横向记录也可，改成blockIndex = i/3 + j/3*3;
                    int blockIndex = i/3*3 + j/3;
                    //在规则内出现重复数字，则返回false
                    if(row[i][num] || col[j][num] || block[blockIndex][num]){
                        return false;
                    }else{
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end

