import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1018 lang=java
 *
 * [1018] 可被 5 整除的二进制前缀
 */

// @lc code=start
/**
 * 因为在整型int范围内只有32位，就算用long也只有64位，
 * 当前问题中说数组长度最大有30000位，所以如果每次累积保存当前数值的话，一定越界。
 * 所以换一种思路，保存当前的余数进行位运算接着求余，判断当前余数是否能被5整除即可
 */
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<Boolean>();
        int mod = 0;
        for (int i = 0; i < A.length; i++) {
            mod = ((mod<<1) + A[i]) % 5;
            res.add(mod == 0);
        }
        return res;
    }
}
// @lc code=end

