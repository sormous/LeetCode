/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
/**
 * 从右往左遍历数字，若当前数字比其左边的一位小，
 * 则将其左边一位的数字-1，并将该位及其右边的所有位改为9
 */
class Solution {
    public int monotoneIncreasingDigits(int N) {
        String num = String.valueOf(N);
        char[] chars = num.toCharArray();
        //flag记录需要修改的位
        int flag = chars.length;
        for (int i = chars.length-1; i > 0; i--) {
            if(chars[i] < chars[i-1]){
                flag = i;
                chars[i-1]--;
            }
        }
        //将flag位及其右边的位都改为9
        for (int i = flag; i < chars.length; i++) {
            chars[i] = '9';
        }
        //最后将字符串转换成整型数字
        return Integer.valueOf(new String(chars));
    }
}
// @lc code=end

