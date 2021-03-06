import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        //若气球数组为空，则直接返回0
        if(points.length == 0) return 0;
        //将气球数组按照坐标右位置大小进行从小到大排序
        Arrays.sort(points, Comparator.comparing(o->o[1]));
        //需要射击的次数，初始化为1，因为若有气球，至少一次
        int res = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            //因为气球出现在同一横坐标，挨着的，可以同时击破，所以取等
            if(points[i][0] <= end){
                continue;
            }
            end = points[i][1];
            res++;
        }
        return res;
    }
}
// @lc code=end

