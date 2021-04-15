/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? Pow(x, n) : 1.0/Pow(x, -n);
    }

    private double Pow(double x, int n){
        if(n == 0){
            return 1.0;
        }
        
        double temp = Pow(x, n/2);
        return n%2 == 0? temp*temp : x*temp*temp;
    }
}
// @lc code=end

