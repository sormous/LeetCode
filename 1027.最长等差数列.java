import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1027 lang=java
 *
 * [1027] 最长等差数列
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        int res = 0;
        //先判空，若数组为空，则直接返回0
        if(n == 0) return res;
        //申明一个map，来记录某下标的数字，在不同等差数值的最长序列
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            for (int j = i-1; j >= 0; j--) {
                //如果遇到相同的差值，则直接跳过，因为其不会比后面的元素能构成的数组长度大
                if(map.get(i).containsKey(A[i]-A[j])) continue;
                //获取以这两个元素差为公差的数组最长子序列
                int cur = map.get(j).getOrDefault(A[i]-A[j], 0);
                res = Math.max(res, cur+2);
                //存入当前元素，某公差下的最长序列
                map.get(i).put(A[i]-A[j], cur+1);
            }
        }
        return res;
    }
}
// @lc code=end

