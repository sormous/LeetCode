import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //首先判断初始条件，若是下面的情况，空数组或者左上角，右下角位置值为1，则直接返回-1
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        //利用一个二维数组记录坐标可以进行移动的操作
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1},};
        int row = grid.length, col = grid[0].length;
        if(grid[0][0] == 1 || grid[row-1][col-1] == 1) return -1;
        //声明一个队列，用作后续BFS，其中存储的是数组中的坐标值
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<Integer,Integer>(0, 0));
        int res = 0;
        while(!q.isEmpty()){
            res++;
            int size = q.size();
            //当队列中元素不为空即可继续向下BFS遍历
            while(size-- > 0){
                Pair<Integer, Integer> cur = q.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                //当前位置的值为1时，直接跳过，因为不能通过
                if(grid[cr][cc] == 1) continue;
                if(cr == row-1 && cc == col-1) return res;
                //做上标记，表示该位置已经访问过
                grid[cr][cc] = 1;
                for (int[] d : direction) {
                    int nr = cr+d[0], nc = cc+d[1];
                    //判断后续需要添加的坐标值是否在范围内
                    if(nr < 0 || nr >=row || nc < 0 || nc >= col){
                        continue;
                    }
                    q.add(new Pair<Integer,Integer>(nr, nc));
                }
            }
        }
        System.out.println(res);
        return -1;
    }
}
// @lc code=end

