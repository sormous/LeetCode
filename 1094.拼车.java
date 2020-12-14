/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
/**
 * 记录乘客数组中每个上下车时间点时，车辆的容量变化情况
 */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] capacityChanges = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            //在上车点时刻，此时车辆的容量为减去当前乘客数
            capacityChanges[trips[i][1]] -= trips[i][0];
            //在下车点时刻，此时车辆的容量为加上当前乘客数
            capacityChanges[trips[i][2]] += trips[i][0];
        }

        for (int i = 0; i < capacityChanges.length; i++) {
            //每次有乘客数量变化时，对capacity进行更新
            capacity += capacityChanges[i];
            if(capacity < 0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

