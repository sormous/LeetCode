import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

// @lc code=start
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();

        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        int rank = 1;
        for (int i = 0; i < temp.length; i++) {
            if(!map.containsKey(temp[i])){
                map.put(temp[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }

        return res;
    }
}
// @lc code=end

