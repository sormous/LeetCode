import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        //首先判空，则直接返回空数组
        if(intervals.length == 0){
            return new int[0][2];
        }
        //然后对数组进行排序，按照每一个子数组中第一个元素进行从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //得到当前数组元素的左右边界
            int L = intervals[i][0], R = intervals[i][1];
            //如果存储结果列表大小为0或者当前存储中最后一个数组的右边界小于将要新增的左边界，则直接添加
            if(merged.size() == 0 || merged.get(merged.size()-1)[1] < L){
                merged.add(new int[]{L, R});
            }
            //否则将当前存储中的这个数组的有边界修改为较大的那一个
            else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end

