import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        //声明一个列表来存储结果
        List<List<Integer>> res = new ArrayList<>();
        //再声明一个numRows*numRows的数组
        int[][] arr = new int[numRows][numRows];
        //进行遍历，每一行的开始和结尾初始化为1
        //后续每一行的元素则等于其上一行的左上与右上的和
        for (int i = 0; i < numRows; i++) {
            //每次遍历重置subList，记录每一行的元素值
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0 || j==i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
                subList.add(arr[i][j]);
            }
            res.add(subList);
        }
        return res;
    }
}
// @lc code=end

