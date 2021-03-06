/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
/**
 * 利用二分查找法，得到平方根
 * 因为算法需要去除小数部分，所以应该返回退出循环较小的哪一个边界值，即r右边界
 * 当除以中间值之后，小于中间值，则说明中间值取大了，修改边界
 */
class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int l=0, r=x;
        int m = 0;
        while(l<=r){
            m = l+(r-l)/2;
            if(m == x/m){
                return m;
            }else if(m > x/m){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return r;
    }
}
// @lc code=end

