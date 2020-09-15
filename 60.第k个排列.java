import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        //候选数字
        List<Integer> candidates = new ArrayList<Integer>();
        //阶乘值
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        int fact = 1;
        //将候选数字和阶乘值放入数组
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        //因为数组从0开始计数。所以k-1
        k -= 1;
        for(int i=n-1; i>=0; i--){
            //计算候选数字的位置
            int index = k/factorials[i];
            //选中后移除
            sb.append(candidates.remove(index));
            //k重置为余数
            k -= index*factorials[i];
        }

        return sb.toString();
    }
}
// @lc code=end

