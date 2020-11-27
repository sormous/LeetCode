import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
/**
 * 遍历 A 和 B 所有元素和的组合情况，
 * 并记录在 ab_map 中，ab_map 的 key 为两数和，
 * value 为该两数和出现的次数
 * 遍历 C 和 D 所有元素和的组合情况，取和的负值判断其是否在 ab_map 中，
 * 若存在则取出 ab_map 对应的 value 值，count = count + value
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> ab_map = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                ab_map.put(a+b, ab_map.getOrDefault(a+b, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int s = -(c+d);
                if(ab_map.containsKey(s)){
                    count += ab_map.get(s);
                }
            }
        }

        return count;
    }
}
// @lc code=end

