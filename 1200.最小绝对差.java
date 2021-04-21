import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1200 lang=java
 *
 * [1200] 最小绝对差
 */

// @lc code=start
class Solution {
    /**
     * 首先将数组排序，然后求出每相邻两个元素的差值，并找出最小差值
     * 然后遍历差值数组，根据位置返回相应值
     * @param arr
     * @return List<List<Integer>> res
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);

        int[] Diff = new int[arr.length-1];
        int MinDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            Diff[i] = arr[i+1] - arr[i];
            if(Diff[i] < MinDifference){
                MinDifference = Diff[i];
            }
        }

        for (int i = 0; i < Diff.length; i++) {
            if(Diff[i] == MinDifference){
                List<Integer> temp = Arrays.asList(arr[i], arr[i+1]);
                res.add(temp);
            }
        }

        return res;
    }
}
// @lc code=end

