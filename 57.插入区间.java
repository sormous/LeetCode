import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int n = intervals.length;
        int l1 = newInterval[0], r1 = newInterval[1];
        //用来表示需要的插入的区间newInterval是否已经插入
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            //记录当前遍历到的区间左右界
            int l2 = intervals[i][0], r2 = intervals[i][1];
            //如果res不为空且newInterVal已经插入
            //则将对比区间改为当前结果集中的最后一个区间
            if(!res.isEmpty() && flag){
                l1 = res.get(res.size()-1)[0];
                r1 = res.get(res.size()-1)[1];
            }
            //如果当前遍历区间与对比区间有交集，那么进行插入和修改操作
            if(r1 >= l2 && r2 >= l1){
                int l_temp = Math.min(l1, l2);
                int r_temp = Math.max(r1, r2);
                if(flag){
                    res.remove(res.size()-1);
                }
                res.add(new int[]{l_temp, r_temp});
                flag = true;
            }else{
                //如果没有交集，那么根据flag判断newInterval是否已经插入
                //没有插入，则比较其右边界和当前遍历区间的左边界
                if(!flag && r1 < l2){
                    flag = true;
                    res.add(newInterval);
                }
                //然后插入当前遍历区间
                res.add(intervals[i]);
            }
        }
        //最后，如果newInterval没有插入过，则将其插入
        if(!flag) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

