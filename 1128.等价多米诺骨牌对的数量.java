import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1128 lang=java
 *
 * [1128] 等价多米诺骨牌对的数量
 */

// @lc code=start
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] num = new int[100];

        //将两个数字统一映射，均将大的数放在前，小的数放在后
        for (int[] dominoe : dominoes) {
            int val = dominoe[0] > dominoe[1] ? dominoe[0]*10+dominoe[1] : dominoe[1]*10+dominoe[0];
            res += num[val];
            num[val]++;
        }

        // //双层循环的遍历，n^2的时间复杂度超时
        // for (int i = 0; i < dominoes.length; i++) {
        //     for (int j = i+1; j < dominoes.length; j++) {
        //         if((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
        //             || (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])){
        //                 res++;
        //             }
        //     }
        // }
        return res;
    }
}
// @lc code=end

