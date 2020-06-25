/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 */

// @lc code=start
/**
 * 面对4的整数倍的人永远无法赢，
 * 你拿N根对手就会拿4-N根，保证每回合共减4根，你永远对面4倍数，直到4. 
 * 相反，如果最开始不是4倍数，你可以拿掉刚好剩下4倍数根，让他永远对面4倍数。
 * 所以本题只需要判断n对4求余是否为0即可判断
 */
class Solution {
    public boolean canWinNim(int n) {
        if(n%4 == 0) return false;
        else return true;
    }
}
// @lc code=end

