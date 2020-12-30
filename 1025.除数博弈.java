/*
 * @lc app=leetcode.cn id=1025 lang=java
 *
 * [1025] 除数博弈
 */

// @lc code=start
/**
 * Alice 处在 N=k 的状态时，他（她）做一步操作，必然使得 Bob 处于 N=m(m<k) 的状态。
 * 因此我们只要看是否存在一个 m 是必败的状态，那么 Alice 直接执行对应的操作让当前的数字变成 m，Alice 就必胜了，
 * 如果没有任何一个是必败的状态的话，说明 Alice 无论怎么进行操作，最后都会让 Bob 处于必胜的状态，此时 Alice 是必败的。

结合以上我们定义 f[i] 表示当前数字 i 的时候先手是处于必胜态还是必败态，true 表示先手必胜，false 表示先手必败，
从前往后递推，根据我们上文的分析，枚举 i 在 (0,i) 中 i 的因数 j，看是否存在 f[i−j] 为必败态即可。
 */
class Solution {
    public boolean divisorGame(int N) {
        boolean[] f = new boolean[N+3];
        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if((i%j == 0) && !f[i-j]){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[N];
    }
}
// @lc code=end

