/*
 * @lc app=leetcode.cn id=788 lang=java
 *
 * [788] 旋转数字
 */

// @lc code=start
/**
 * 如果 X 中存在 3、4、7 这样的无效数字，则 X 不是一个好数。
 * 如果 X 中不存在 2、5、6、9 这样的旋转后会变成不同的数字，
 * 则 X 不是一个好数。
 * 否则，X 可以旋转成一个不同的有效数字。
 */
class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if(isgood(i, false)) res++;
        }
        return res;
    }

    //递归判断每一位数字
    private boolean isgood(int n, boolean flag){
        //若当前位数字为0，则返回对应的flag，初始flag为false
        if(n == 0) return flag;
        n = n%10;
        //若存在3，4，7，则一定不是好数
        if(n == 3 || n == 4 || n == 7) return false;
        //若存在0、1、8，则需要进一步判断
        if(n == 0 || n == 1 || n == 8) return isgood(n/10, flag);
        //已经存在2、5、6、9，则需要判断下一位，是否为好数
        return isgood(n/10, true);
    }
}
// @lc code=end

