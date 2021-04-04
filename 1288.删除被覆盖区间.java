import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        //找到覆盖区间的个数
        int res = 0;
        //排序规则，按照左界升序，右界降序
        Arrays.sort(intervals, (a, b)->{
            if(a[0] == b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //1. 覆盖区间，判断规则，当前区间，在所记录的标准区间[left,right]的覆盖范围内
            if(left <= intervals[i][0] && right >= intervals[i][1]){
                res++;
            }
            //2. 相交区间，合并
            if(right >= intervals[i][0] && right <= intervals[i][1]){
                right = intervals[i][1];
            }
            //3. 完全不相交区间，更新记录区间的起点终点
            if(right < intervals[i][0]){
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}
// @lc code=end

